package com.example.gestionstage.domain;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tuteur_entreprise")
public class TuteurEntreprise implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "matricule", nullable = false)
    private String matricule;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @OneToMany(mappedBy = "tuteurEntreprise")
    private Set<DemandeStage> demandeStages = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public TuteurEntreprise matricule(String matricule) {
        this.matricule = matricule;
        return this;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public TuteurEntreprise nom(String nom) {
        this.nom = nom;
        return this;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public TuteurEntreprise prenom(String prenom) {
        this.prenom = prenom;
        return this;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Set<DemandeStage> getDemandeStages() {
        return demandeStages;
    }

    public TuteurEntreprise demandeStages(Set<DemandeStage> demandeStages) {
        this.demandeStages = demandeStages;
        return this;
    }

    public TuteurEntreprise addDemandeStage(DemandeStage demandeStage) {
        this.demandeStages.add(demandeStage);
        demandeStage.setTuteurEntreprise(this);
        return this;
    }

    public TuteurEntreprise removeDemandeStage(DemandeStage demandeStage) {
        this.demandeStages.remove(demandeStage);
        demandeStage.setTuteurEntreprise(null);
        return this;
    }

    public void setDemandeStages(Set<DemandeStage> demandeStages) {
        this.demandeStages = demandeStages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TuteurEntreprise)) {
            return false;
        }
        return id != null && id.equals(((TuteurEntreprise) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "TuteurEntreprise{" +
            "id=" + getId() +
            ", matricule='" + getMatricule() + "'" +
            ", nom='" + getNom() + "'" +
            ", prenom='" + getPrenom() + "'" +
            "}";
    }
}
