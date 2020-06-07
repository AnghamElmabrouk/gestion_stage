package com.example.gestionstage.domain;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "stage")
public class Stage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "id_stage", nullable = false)
    private String idStage;

    @Column(name = "nature_stage")
    private String natureStage;

    @OneToMany(mappedBy = "stage")
    private Set<Sujet> sujets = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdStage() {
        return idStage;
    }

    public Stage idStage(String idStage) {
        this.idStage = idStage;
        return this;
    }

    public void setIdStage(String idStage) {
        this.idStage = idStage;
    }

    public String getNatureStage() {
        return natureStage;
    }

    public Stage natureStage(String natureStage) {
        this.natureStage = natureStage;
        return this;
    }

    public void setNatureStage(String natureStage) {
        this.natureStage = natureStage;
    }

    public Set<Sujet> getSujets() {
        return sujets;
    }

    public Stage sujets(Set<Sujet> sujets) {
        this.sujets = sujets;
        return this;
    }

    public Stage addSujet(Sujet sujet) {
        this.sujets.add(sujet);
        sujet.setStage(this);
        return this;
    }

    public Stage removeSujet(Sujet sujet) {
        this.sujets.remove(sujet);
        sujet.setStage(null);
        return this;
    }

    public void setSujets(Set<Sujet> sujets) {
        this.sujets = sujets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Stage)) {
            return false;
        }
        return id != null && id.equals(((Stage) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Stage{" +
            "id=" + getId() +
            ", idStage='" + getIdStage() + "'" +
            ", natureStage='" + getNatureStage() + "'" +
            "}";
    }
}
