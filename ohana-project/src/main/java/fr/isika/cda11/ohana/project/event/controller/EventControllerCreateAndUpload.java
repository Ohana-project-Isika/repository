package fr.isika.cda11.ohana.project.event.controller;

import fr.isika.cda11.ohana.project.event.models.Event;
import fr.isika.cda11.ohana.project.event.service.EventService;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
@Getter
@Setter
public class EventControllerCreateAndUpload implements Serializable {

    private static final long serialVersionUID = -1606040173965309710L;

    // Utilisé pour le formulaire de création d'évènement
    private List<Event> events;
    private String folder = "C:\\Github\\Ohana\\ohana-project\\src\\main\\webapp\\resources\\eventBackground\\";
    private Part uploadedFile;

    private Event event = new Event();

    @Inject
    private EventService eventService;

    public String getFolder() {
        return folder;
    }
    public void setFolder(String folder) {
        this.folder = folder;
    }

    public Part getUploadedFile() {
        return uploadedFile;
    }
    public void setUploadedFile(Part uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    @PostConstruct
    private void init() {
        events = eventService.findAll();
    }

    public String addEvent() {
        eventService.create(event);
        saveFile();
        event.setImageFileName("../resources/eventBackground/"+getFilename(uploadedFile));
        this.events = eventService.findAll();
        this.event = new Event();
        return "eventsList";
    }

    // Méthode upload
    public void saveFile() {

        System.out.println("saveFile method invoked..");
        System.out.println( "content-type:{0}" + uploadedFile.getContentType());
        System.out.println("filename:{0}" + uploadedFile.getName());
        System.out.println( "submitted filename:{0}"+ uploadedFile.getSubmittedFileName());
        System.out.println( "size:{0}" + uploadedFile.getSize());
        String fileName = "";

        try {

            fileName = getFilename(uploadedFile);

            System.out.println("fileName  " + fileName);

            uploadedFile.write(folder+fileName);


        } catch (IOException ex) {
            System.out.println(ex);


        }

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("File " + fileName+ " Uploaded!"));

    }

    private static String getFilename(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }

}