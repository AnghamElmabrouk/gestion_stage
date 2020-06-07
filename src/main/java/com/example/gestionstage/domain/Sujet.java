package com.example.gestionstage.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "sujet")
public class Sujet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "ref_sujet", nullable = false)
    private String refSujet;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JsonIgnoreProperties("sujets")
    private Stage stage;

    @ManyToMany(mappedBy = "sujets")
    @JsonIgnore
    private Set<DocumentFournis> stagiaires = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRefSujet() {
        return refSujet;
    }

    public Sujet refSujet(String refSujet) {
        this.refSujet = refSujet;
        return this;
    }

    public void setRefSujet(String refSujet) {
        this.refSujet = refSujet;
    }

    public String getDescription() {
        return description;
    }

    public Sujet description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Stage getStage() {
        return stage;
    }

    public Sujet stage(Stage stage) {
        this.stage = stage;
        return this;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Set<DocumentFournis> getStagiaires() {
        return stagiaires;
    }

    public Sujet stagiaires(Set<DocumentFournis> documentFournis) {
        this.stagiaires = documentFournis;
        return this;
    }

    public Sujet addStagiaires(DocumentFournis documentFournis) {
        this.stagiaires.add(documentFournis);
        documentFournis.getSujets().add(this);
        return this;
    }

    public Sujet removeStagiaires(DocumentFournis documentFournis) {
        this.stagiaires.remove(documentFournis);
        documentFournis.getSujets().remove(this);
        return this;
    }

    public void setStagiaires(Set<DocumentFournis> documentFournis) {
        this.stagiaires = documentFournis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Sujet)) {
            return false;
        }
        return id != null && id.equals(((Sujet) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Sujet{" +
            "id=" + getId() +
            ", refSujet='" + getRefSujet() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
}
