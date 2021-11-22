package fr.isika.cda11.ohana.project.event.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import fr.isika.cda11.ohana.project.common.controller.LoginController;
import fr.isika.cda11.ohana.project.common.dto.AccountDto;
import fr.isika.cda11.ohana.project.common.dto.PrivatePersonDto;
import fr.isika.cda11.ohana.project.common.factories.PrivatePersonFactory;
import fr.isika.cda11.ohana.project.common.models.PrivatePerson;
import fr.isika.cda11.ohana.project.common.service.AccountService;
import fr.isika.cda11.ohana.project.common.service.PrivatePersonService;
import fr.isika.cda11.ohana.project.event.models.Order;
import fr.isika.cda11.ohana.project.event.models.Ticket;
import fr.isika.cda11.ohana.project.event.service.PaymentService;
import fr.isika.cda11.ohana.project.event.service.TicketService;
import lombok.Getter;
import lombok.Setter;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.*;

import static fr.isika.cda11.ohana.project.common.models.Constant.ACCOUNT_ATTRIBUTE;

@ManagedBean
@SessionScoped
@Getter
@Setter
public class PaymentController implements Serializable {

    @Inject
    private PaymentService paymentService;

    @Inject
    private AccountService accountService;

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
            return "verificationPanier";
        }
    }

    public String completePayment() {
        return "completePayment";
    }

    public String validatePayment() {
        AccountDto accountDto = accountService.findAccountByIdService(loggedInUser);
        PrivatePersonDto privatePersonDto = privatePersonService.findPrivatePersonByAccount(accountDto);

        order.getTicketsByIds().forEach((key, value) -> {
            value.setPrivatePerson(PrivatePersonFactory.fromPrivatePersonDto(privatePersonDto));
            ticketService.update(value);
            tickets.add(value);
            privatePersonDto.addTicket(value);
        });
        privatePerson = privatePersonService.updatePrivatePerson(privatePersonDto);

        return "validatePayment";
    }

    public String backToCart() {
        return "reservation";
    }

    public String download(Ticket ticket) throws FileNotFoundException {
        this.ticket = ticket;

        //data that we want to store in the QR code
        String str = String.format("MON BILLET\n" +
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
                "Prix HT : %s\n" +
                "Taxe : %s\n" +
                "Prix TTC : %s\n" +
                "----------\n" +
                "CE BILLET EST UNIQUEMENT VALABLE\n" +
                "POUR L'EVENEMENT INDIQUE ET POUR SON DETENTEUR.\n" +
                "UNE PIECE D'IDENTITE POURRA VOUS ETRE DEMANDE.\n" +
                "LE BILLET N'EST NI ECHANGEABLE NI NON REMBOURSABLE.\n" +
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

        int size = 400;
        BitMatrix bitMatrix = null;

        // encode
        try {
            bitMatrix = generateMatrix(str, size);
        } catch (WriterException e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(component.getClientId(), new FacesMessage("Erreur de téléchargement. Veuillez nous contacter"));
            e.printStackTrace();
        }

        String imageFormat = "png";
        String outputFileName = "src/main/webapp/resources/gfx/qrCode." + imageFormat;

        System.out.println("fffffffffffffffffffffff" + new FileOutputStream(outputFileName));
        // write in a file
        try {
            writeImage(outputFileName, imageFormat, bitMatrix);
        } catch (IOException ioException) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(component.getClientId(), new FacesMessage("Erreur de téléchargement. Veuillez nous contacter"));
            ioException.printStackTrace();
        }

        System.out.println("Holaaaaaaaaaaaaaa");
        return "telechargement?faces-redirect=true";
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

    private static void writeImage(String outputFileName, String imageFormat, BitMatrix bitMatrix) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(outputFileName);
        MatrixToImageWriter.writeToStream(bitMatrix, imageFormat, fileOutputStream);
        fileOutputStream.close();
    }
}
