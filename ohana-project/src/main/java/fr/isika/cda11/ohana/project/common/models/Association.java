package fr.isika.cda11.ohana.project.common.models;

import javax.persistence.*;

/**
 * Created on 11/03/2021
 * @author manu
 */
@Entity
public class Association {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @OneToOne
    private Address address;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public long getId() {
        return id;
    }
    public Association(String name, Address address) {

        this.name = name;
        this.address = address;
    }

    public Association() {

    }
}
