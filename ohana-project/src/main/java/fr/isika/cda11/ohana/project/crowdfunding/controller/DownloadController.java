//package fr.isika.cda11.ohana.project.crowdfunding.controller;
//
//import javax.faces.bean.RequestScoped;
//import javax.inject.Named;
//
//import org.primefaces.model.DefaultStreamedContent;
//import org.primefaces.model.StreamedContent;
//
//@Named
//@RequestScoped
//public class DownloadController {
//	
//	private StreamedContent file;
//	 
//    public DownloadController() {
//        file = DefaultStreamedContent.builder()
//                .name("downloaded_boromir.jpg")
//                .contentType("image/jpg")
//                .stream(() -> FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/demo/images/boromir.jpg"))
//                .build();
//    }
// 
//    public StreamedContent getFile() {
//        return file;
//    }
//
////
