package fr.isika.cda11.ohana.project.event.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String eventName;
    private String eventDescription;
    private LocalDate dateOfStart;
    private LocalDate dateOfEnd;
    private Integer numberOfTicket;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "event_ticket_id")
    private List<Ticket> tickets = new ArrayList<>();

    public Long getId() {return id;}

    public String getEventName() {return eventName;}
    public void setEventName(String eventName) {this.eventName = eventName;}

    public String getEventDescription() {return eventDescription;}
    public void setEventDescription(String eventDescription) {this.eventDescription = eventDescription;}

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
                && Objects.equals(eventName, event.eventName)
                && Objects.equals(eventDescription, event.eventDescription)
                && Objects.equals(dateOfStart, event.dateOfStart)
                && Objects.equals(dateOfEnd, event.dateOfEnd)
                && Objects.equals(numberOfTicket, event.numberOfTicket)
                && Objects.equals(tickets, event.tickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eventName, eventDescription, dateOfStart, dateOfEnd, numberOfTicket, tickets);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + eventName + '\'' +
                ", description='" + eventDescription + '\'' +
                ", dateOfStart=" + dateOfStart +
                ", dateOfEnd=" + dateOfEnd +
                ", numberOfTicket=" + numberOfTicket +
                ", tickets=" + tickets +
                '}';
    }
}
