package com.example.gestionstage.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "document_fournis")
public class DocumentFournis implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(name = "document_fournis_sujet",
               joinColumns = @JoinColumn(name = "document_fournis_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "sujet_id", referencedColumnName = "id"))
    private Set<Sujet> sujets = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "document_fournis_stagiaire",
               joinColumns = @JoinColumn(name = "document_fournis_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "stagiaire_id", referencedColumnName = "id"))
    private Set<Stagiaire> stagiaires = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Sujet> getSujets() {
        return sujets;
    }

    public DocumentFournis sujets(Set<Sujet> sujets) {
        this.sujets = sujets;
        return this;
    }

    public DocumentFournis addSujet(Sujet sujet) {
        this.sujets.add(sujet);
        sujet.getStagiaires().add(this);
        return this;
    }

    public DocumentFournis removeSujet(Sujet sujet) {
        this.sujets.remove(sujet);
        sujet.getStagiaires().remove(this);
        return this;
    }

    public void setSujets(Set<Sujet> sujets) {
        this.sujets = sujets;
    }

    public Set<Stagiaire> getStagiaires() {
        return stagiaires;
    }

    public DocumentFournis stagiaires(Set<Stagiaire> stagiaires) {
        this.stagiaires = stagiaires;
        return this;
    }

    public DocumentFournis addStagiaire(Stagiaire stagiaire) {
        this.stagiaires.add(stagiaire);
        stagiaire.getSujets().add(this);
        return this;
    }

    public DocumentFournis removeStagiaire(Stagiaire stagiaire) {
        this.stagiaires.remove(stagiaire);
        stagiaire.getSujets().remove(this);
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
        if (!(o instanceof DocumentFournis)) {
            return false;
        }
        return id != null && id.equals(((DocumentFournis) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "DocumentFournis{" +
            "id=" + getId() +
            "}";
    }
}
