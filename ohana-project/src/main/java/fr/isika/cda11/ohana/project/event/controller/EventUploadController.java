package fr.isika.cda11.ohana.project.event.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class EventUploadController implements Serializable {

    //---------------test
    private String folder = "C:\\Github\\Ohana\\ohana-project\\src\\main\\webapp\\resources\\eventBackground\\";
    private Part uploadedFile;
    public Part getUploadedFile() {return uploadedFile;}
    public void setUploadedFile(Part uploadedFile) {this.uploadedFile = uploadedFile;}
    private String folder2 = "C:\\Github\\Ohana\\ohana-project\\src\\main\\webapp\\resources\\justification\\";
    private Part uploadedFile2;
    public Part getUploadedFile2() {return uploadedFile2;}
    public void setUploadedFile2(Part uploadedFile2) {this.uploadedFile2 = uploadedFile2;}

    //upload file---------------------------

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



    public void saveFile2() {

        System.out.println("saveFile method invoked..");
        System.out.println( "content-type:{0}" + uploadedFile2.getContentType());
        System.out.println("filename:{0}" + uploadedFile2.getName());
        System.out.println( "submitted filename:{0}"+ uploadedFile2.getSubmittedFileName());
        System.out.println( "size:{0}" + uploadedFile2.getSize());
        String fileName2 = "";

        try {

            fileName2 = getFilename2(uploadedFile2);

            System.out.println("fileName2  " + fileName2);

            uploadedFile2.write(folder2+fileName2);


        } catch (IOException ex) {
            System.out.println(ex);


        }

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("File " + fileName2+ " Uploaded!"));

    }


    private static String getFilename2(Part part2) {
        for (String cd : part2.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename2 = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return filename2.substring(filename2.lastIndexOf('/') + 1).substring(filename2.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
