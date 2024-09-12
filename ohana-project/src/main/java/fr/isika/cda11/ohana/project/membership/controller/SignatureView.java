package fr.isika.cda11.ohana.project.membership.controller;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class SignatureView {

	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}