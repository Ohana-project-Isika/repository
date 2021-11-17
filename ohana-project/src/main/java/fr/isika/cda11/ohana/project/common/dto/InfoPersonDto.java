package fr.isika.cda11.ohana.project.common.dto;


public class InfoPersonDto {

	private long id;
	private String nom;
	private String prenom;
	private AddressDto address;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public AddressDto getAddress() {
		return address;
	}
	public void setAddress(AddressDto address) {
		this.address = address;
	}
	public InfoPersonDto() {
		
	}
	
	
}
