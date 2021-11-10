package fr.isika.cda11.ohana.project.event.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Participant implements Serializable {

    private static final long serialVersionUID = 8845474287191812919L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "participant")
    private PrivatePerson privatePerson;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "event_ticket_id")
    private List<Ticket> tickets = new ArrayList<>();

    public Long getId() {return id;}

    public PrivatePerson getPrivatePerson() {return privatePerson;}
    public void setPrivatePerson(PrivatePerson privatePerson) {this.privatePerson = privatePerson;}

    public List<Ticket> getTickets() {return tickets;}
    public void setTickets(List<Ticket> tickets) {this.tickets = tickets;}

    public Participant() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(id, that.id)
                && Objects.equals(privatePerson, that.privatePerson)
                && Objects.equals(tickets, that.tickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, privatePerson, tickets);
    }

    @Override
    public String toString() {
        return "Participant{" +
                "id=" + id +
                ", privatePerson=" + privatePerson +
                ", tickets=" + tickets +
                '}';
    }
}
