package fr.isika.cda11.ohana.project.event.models;

import javax.persistence.*;

@Entity
public class PrivatePerson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "participant_id")
    private Participant participant;

    public Participant getParticipant() {return participant;}
    public void setParticipant(Participant participant) {this.participant = participant;}
}
