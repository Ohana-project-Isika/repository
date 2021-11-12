package fr.isika.cda11.ohana.project.membership.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	private InfoPerson infoPerson;

}
