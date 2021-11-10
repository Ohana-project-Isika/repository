package fr.isika.cda11.ohana.project.event.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Event implements Serializable {

    private static final long serialVersionUID = 8845474287191812919L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private LocalDate dateOfStart;
    private LocalDate dateOfEnd;
    private Integer numberOfTicket;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "event_ticket_id")
    private List<Ticket> tickets = new ArrayList<>();

    public Long getId() {return id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public LocalDate getDateOfStart() {return dateOfStart;}
    public void setDateOfStart(LocalDate dateOfStart) {this.dateOfStart = dateOfStart;}

    public LocalDate getDateOfEnd() {return dateOfEnd;}
    public void setDateOfEnd(LocalDate dateOfEnd) {this.dateOfEnd = dateOfEnd;}

    public Integer getNumberOfTicket() {return numberOfTicket;}
    public void setNumberOfTicket(Integer numberOfTicket) {this.numberOfTicket = numberOfTicket;}

    public List<Ticket> getTickets() {return tickets;}
    public void setTickets(List<Ticket> tickets) {this.tickets = tickets;}

    public Event() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(id, event.id)
                && Objects.equals(name, event.name)
                && Objects.equals(description, event.description)
                && Objects.equals(dateOfStart, event.dateOfStart)
                && Objects.equals(dateOfEnd, event.dateOfEnd)
                && Objects.equals(numberOfTicket, event.numberOfTicket)
                && Objects.equals(tickets, event.tickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, dateOfStart, dateOfEnd, numberOfTicket, tickets);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dateOfStart=" + dateOfStart +
                ", dateOfEnd=" + dateOfEnd +
                ", numberOfTicket=" + numberOfTicket +
                ", tickets=" + tickets +
                '}';
    }
}
