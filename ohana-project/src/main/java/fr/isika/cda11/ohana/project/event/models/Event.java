package fr.isika.cda11.ohana.project.event.models;

import fr.isika.cda11.ohana.project.common.models.Address;
import lombok.*;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NamedQueries({
        @NamedQuery(name = "Events.findAll", query = "SELECT DISTINCT e FROM Event e")
})
public class Event {

    // TODO Field Validation Errors
    // TODO Other Field Validation Controls if Any

    //region Entity fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "event_name")
    private String name;

    @Column(name = "event_description")
    private String description;

    @Column(name = "start_date")
    private Date startDate;
    public Date getStartDate() {return startDate;}
    public void setStartDate(Date startDate) {this.startDate = startDate;}

    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "modification_date")
    private Date modificationDate;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_date")
    private Date endDate;
    public Date getEndDate() {return endDate;}
    public void setEndDate(Date endDate) {this.endDate = endDate;}

    @Column(name = "end_time")
    private LocalTime endTime;

    @Column(name = "image_file_name")
    private String imageFileName;

    public String getImageFileName() {return imageFileName;}
    public void setImageFileName(String imageFileName) {this.imageFileName = imageFileName;}

    @Column(name = "image_description")
    private String imageDescription;
    public String getImageDescription() {return imageDescription;}
    public void setImageDescription(String imageDescription) {this.imageDescription = imageDescription;}

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE },
            mappedBy = "event",
            orphanRemoval = true
    )
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Ticket> tickets = new ArrayList<>();

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Ticketing ticketing;

    @OneToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Address address;
    //endregion

    //region Transient fields
    @Transient
    private int ticketQuantity;

    @Transient
    private Ticket ticket;

    @Transient
    private String endDateString;

    @Transient
    private String startDateString;

    @Transient
    private String fullAddress;
    //endregion
}
