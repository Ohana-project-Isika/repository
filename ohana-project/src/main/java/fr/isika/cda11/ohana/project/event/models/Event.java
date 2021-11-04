package fr.isika.cda11.ohana.project.event.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String name;
    private String description;
    private LocalDate dateOfStart;
    private LocalDate dateOfEnd;
    private Integer numberOfTicket;

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
                && Objects.equals(numberOfTicket, event.numberOfTicket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, dateOfStart, dateOfEnd, numberOfTicket);
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
                '}';
    }
}
