package fr.isika.cda11.ohana.project.common.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created on 11/03/2021
 *
 * @author manu
 */
@Entity
public class Address /*implements Serializable*/ {

//    private static final long serialVersionUID = 8803763357383317624L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Integer streetNumber;
    private String street;
    private String department;
    private String city;
    public Integer getStreetNumber() {
        return streetNumber;
    }
    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public long getId() {
        return id;
    }

    public Address() {

    }

    public Address(Integer number, String street, String department, String city) {
        this.streetNumber = number;
        this.street = street;
        this.department = department;
        this.city = city;
    }

}

