package com.example.gestionstage.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "demande_stage")
public class DemandeStage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "etat_demande")
    private String etatDemande;

    @Column(name = "date_creation")
    private Date dateCreation;

    @Column(name = "date_debut")
    private Instant dateDebut;

    @Column(name = "date_fin")
    private Instant dateFin;

    @ManyToOne
    @JsonIgnoreProperties("demandeStages")
    private TuteurEntreprise tuteurEntreprise;

    @ManyToMany(mappedBy = "demandeStages")
    @JsonIgnore
    private Set<Stagiaire> stagiaires = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEtatDemande() {
        return etatDemande;
    }

    public DemandeStage etatDemande(String etatDemande) {
        this.etatDemande = etatDemande;
        return this;
    }

    public void setEtatDemande(String etatDemande) {
        this.etatDemande = etatDemande;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public DemandeStage dateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
        return this;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Instant getDateDebut() {
        return dateDebut;
    }

    public DemandeStage dateDebut(Instant dateDebut) {
        this.dateDebut = dateDebut;
        return this;
    }

    public void setDateDebut(Instant dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Instant getDateFin() {
        return dateFin;
    }

    public DemandeStage dateFin(Instant dateFin) {
        this.dateFin = dateFin;
        return this;
    }

    public void setDateFin(Instant dateFin) {
        this.dateFin = dateFin;
    }

    public TuteurEntreprise getTuteurEntreprise() {
        return tuteurEntreprise;
    }

    public DemandeStage tuteurEntreprise(TuteurEntreprise tuteurEntreprise) {
        this.tuteurEntreprise = tuteurEntreprise;
        return this;
    }

    public void setTuteurEntreprise(TuteurEntreprise tuteurEntreprise) {
        this.tuteurEntreprise = tuteurEntreprise;
    }

    public Set<Stagiaire> getStagiaires() {
        return stagiaires;
    }

    public DemandeStage stagiaires(Set<Stagiaire> stagiaires) {
        this.stagiaires = stagiaires;
        return this;
    }

    public DemandeStage addStagiaire(Stagiaire stagiaire) {
        this.stagiaires.add(stagiaire);
        stagiaire.getDemandeStages().add(this);
        return this;
    }

    public DemandeStage removeStagiaire(Stagiaire stagiaire) {
        this.stagiaires.remove(stagiaire);
        stagiaire.getDemandeStages().remove(this);
        return this;
    }

    public void setStagiaires(Set<Stagiaire> stagiaires) {
        this.stagiaires = stagiaires;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DemandeStage)) {
            return false;
        }
        return id != null && id.equals(((DemandeStage) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "DemandeStage{" +
            "id=" + getId() +
            ", etatDemande='" + getEtatDemande() + "'" +
            ", dateCreation='" + getDateCreation() + "'" +
            ", dateDebut='" + getDateDebut() + "'" +
            ", dateFin='" + getDateFin() + "'" +
            "}";
    }
}
