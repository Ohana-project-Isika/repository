package fr.isika.cda11.ohana.project.event.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import fr.isika.cda11.ohana.project.common.dto.AccountDto;
import fr.isika.cda11.ohana.project.common.dto.PrivatePersonDto;
import fr.isika.cda11.ohana.project.common.factories.PrivatePersonFactory;
import fr.isika.cda11.ohana.project.common.models.MeansOfPayment;
import fr.isika.cda11.ohana.project.common.models.PrivatePerson;
import fr.isika.cda11.ohana.project.common.service.AccountService;
import fr.isika.cda11.ohana.project.common.service.PrivatePersonService;
import fr.isika.cda11.ohana.project.event.models.Event;
import fr.isika.cda11.ohana.project.event.models.Order;
import fr.isika.cda11.ohana.project.event.models.Ticket;
import fr.isika.cda11.ohana.project.event.service.EventService;
import fr.isika.cda11.ohana.project.event.service.PaymentService;
import fr.isika.cda11.ohana.project.event.service.TicketService;
import lombok.Getter;
import lombok.Setter;
import org.omnifaces.util.Faces;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.List;

import static fr.isika.cda11.ohana.project.common.models.Constant.ACCOUNT_ATTRIBUTE;

@ManagedBean
@SessionScoped
@Getter
@Setter
public class PaymentController implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1265155192412891891L;

	@Inject
    private PaymentService paymentService;

    @Inject
    private AccountService accountService;

    @Inject
    private EventService eventService;

    @Inject
    private PrivatePersonService privatePersonService;

    @Inject
    private TicketService ticketService;

    private UIComponent component;
    private String url;
    private boolean isPaying;
    private PrivatePerson privatePerson;

    @ManagedProperty(value="#{eventController}")
    private EventController eventController;

    private String cardNumber;
    private String fullName;
    private String expiry;
    private String cvc;
    private Order order;
    private Date minExpiry = setMinExpiry();
    private Long loggedInUser;
    private List<Ticket> tickets = new ArrayList<>();
    private Ticket ticket;

    private Map<String, String> meansMap;
    private String means;
    private boolean payCard;
    private boolean registerCard;
    private String ticketFile;
    private File file;

    @PostConstruct
    public void init() {
        meansMap = new HashMap<>();
        meansMap.put("PAYPAL", "PAYPAL");
        meansMap.put("CB", "CB");
    }

    public String pay() {
        order = eventController.getCart();
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
                .getSession(false);
        if (session.getAttribute(ACCOUNT_ATTRIBUTE) == null) {
            isPaying = true;
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(component.getClientId(), new FacesMessage("Vous devez d'abord vous connecter pour " +
                    "poursuivre le paiement"));
            return "";
        } else {
            return "verificationPanier?faces-redirect=true";
        }
    }

    public String completePayment() {
        return "completePayment";
    }

    public String validatePayment() {
        tickets.clear();
        AccountDto accountDto = accountService.findAccountByIdService(loggedInUser);
        PrivatePersonDto privatePersonDto = privatePersonService.findPrivatePersonByAccount(accountDto);
        MeansOfPayment meansOfPayment = new MeansOfPayment();

        order.getTicketsByIds().forEach((key, value) -> {
            value.setPrivatePerson(PrivatePersonFactory.fromPrivatePersonDto(privatePersonDto));

            if (registerCard) {
                meansOfPayment.setPrivatePerson(PrivatePersonFactory.fromPrivatePersonDto(privatePersonDto));
                meansOfPayment.setFullName(fullName);
                meansOfPayment.setCardNumber(cardNumber);
                meansOfPayment.setCvc(cvc);
                meansOfPayment.setExpiry(expiry);
                privatePersonDto.addMeans(meansOfPayment);
            }

            ticketService.update(value);
            privatePersonDto.addTicket(value);
            privatePerson = privatePersonService.updatePrivatePerson(privatePersonDto);

            try {
                download(value);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            value.setFile(file);
            tickets.add(value);
        });

        return "validatePayment";
    }

    public void downloadTicket(Ticket ticket) throws IOException {
        Faces.sendFile(ticket.getFile(), true);
    }

    public String backToCart() {
        return "reservation";
    }

    public String download(Ticket ticket) throws FileNotFoundException {
        this.ticket = ticket;

        //data that we want to store in the QR code
        String string = String.format("MON BILLET\n" +
                "----------\n" +
                "INFORMATIONS PERSONNELLES \n" +
                "Prénom : %s\n" +
                "Nom : %s\n" +
                "\n" +
                "INFORMATIONS EVENEMENT\n" +
                "Organisateur : %s\n" +
                "Nom : %s\n" +
                "\n" +
                "Date de début : %s\n" +
                "Heure de début : %s\n" +
                "\n" +
                "Date de fin : %s\n" +
                "Heure de fin : %s\n" +
                "\n" +
                "Lieu : %s\n" +
                "\n" +
                "Prix HT : %s€\n" +
                "Taxe : %s%%\n" +
                "Prix TTC : %s€\n" +
                "----------\n" +
                "CE BILLET EST UNIQUEMENT VALABLE\n" +
                "POUR L'EVENEMENT INDIQUE ET POUR VOUS, SON DETENTEUR.\n" +
                "UNE PIECE D'IDENTITE POURRA VOUS ETRE DEMANDEE.\n" +
                "LE BILLET N'EST NI ECHANGEABLE NI REMBOURSABLE.\n" +
                "POUR TOUTE INFORMATION, VEUILLEZ CONTACTER NOTRE SERVICE \n" +
                "D'ASSISTANCE AU 01 48 55 88 41.\n" +
                "\n" +
                "L'EQUIPE OHANA VOUS REMERCIE DE VOTRE ACHAT. A TRES BIENTOT.",
                privatePerson.getAccount().getInfoPerson().getFirstName(),
                privatePerson.getAccount().getInfoPerson().getLastName(),
                ticket.getEvent().getTicketing().getAssociation().getNameAssos(),
                ticket.getEvent().getName(),
                ticket.getEvent().getStartDateString(),
                ticket.getEvent().getStartTime(),
                ticket.getEvent().getEndDateString(),
                ticket.getEvent().getEndTime(),
                ticket.getEvent().getFullAddress(),
                ticket.getPreTaxPrice(),
                ticket.getTvaRate(),
                ticket.getPostTaxPrice()
        );

        byte[] bytes = string.getBytes(StandardCharsets.UTF_8);
        String utf8EncodedString = new String(bytes, StandardCharsets.UTF_8);

        int size = 400;
        BitMatrix bitMatrix = null;

        // encode
        try {
            bitMatrix = generateMatrix(utf8EncodedString, size);
        } catch (WriterException e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(component.getClientId(), new FacesMessage("Erreur de téléchargement. Veuillez nous contacter"));
            e.printStackTrace();
        }

        String imageFormat = "pdf";
        File imagesDir = new File(System.getProperty("jboss.server.data.dir"), "images");
        imagesDir.mkdir();
        File file = new File(imagesDir, "qrCode" + ticket.getId() + ".pdf");
        this.file = file;
        ticketFile = file.getAbsolutePath();
        try {
            pdfMaker(file, string);
        } catch (DocumentException e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(component.getClientId(), new FacesMessage("Erreur de téléchargement. Veuillez nous contacter"));
            e.printStackTrace();
        }

        // write in a file
        try {
            writeImage(file, imageFormat, bitMatrix);
        } catch (IOException ioException) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(component.getClientId(), new FacesMessage("Erreur de téléchargement. Veuillez nous contacter"));
            ioException.printStackTrace();
        }

        return "telechargement?faces-redirect=true";
    }

    public void pdfMaker(File file, String text) throws FileNotFoundException, DocumentException {
        // Create a new document.
        Document document = new Document();
        // Get an instance of PdfWriter and create a HelloWorld.pdf
        // file as an output.
        PdfWriter.getInstance(document, new FileOutputStream("HelloWorld.pdf"));
        document.open();

        // Create our first paragraph for the pdf document to be
        // created. We also set the alignment and the font of the
        // paragraph.
        Paragraph paragraph = new Paragraph(text);
        paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
        paragraph.setFont(new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL));

        document.add(paragraph);
        document.close();

        System.out.println("Fin de la méthode");
    }

    public Date setMinExpiry() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 7);
        return calendar.getTime();
    }

    private static BitMatrix generateMatrix(String data, int size) throws WriterException {
        BitMatrix bitMatrix = new QRCodeWriter().encode(data, BarcodeFormat.QR_CODE, size, size);
        return bitMatrix;
    }

    private static void writeImage(File outputFileName, String imageFormat, BitMatrix bitMatrix) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(outputFileName, true);
        MatrixToImageWriter.writeToStream(bitMatrix, imageFormat, fileOutputStream);
        fileOutputStream.close();
    }
}
