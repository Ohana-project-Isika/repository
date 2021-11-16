package fr.isika.cda11.ohana.project.event.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class PrivatePerson {

    private static final long serialVersionUID = 8845474287191812919L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "participant_id")
    private Participant participant;

    public Participant getParticipant() {return participant;}
    public void setParticipant(Participant participant) {this.participant = participant;}
}
