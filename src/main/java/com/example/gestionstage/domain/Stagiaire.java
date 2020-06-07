package com.example.gestionstage.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "stagiaire")
public class Stagiaire implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "cin", nullable = false)
    private String cin;

    @Column(name = "cv")
    private String cv;

    @Column(name = "tel")
    private String tel;

    @Column(name = "email")
    private String email;

    @Column(name = "otp")
    private String otp;


    @ManyToMany
    @JoinTable(name = "stagiaire_demande_stage",
               joinColumns = @JoinColumn(name = "stagiaire_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "demande_stage_id", referencedColumnName = "id"))
    private Set<DemandeStage> demandeStages = new HashSet<>();

    @ManyToMany(mappedBy = "stagiaires")
    @JsonIgnore
    private Set<DocumentFournis> sujets = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCin() {
        return cin;
    }

    public Stagiaire cin(String cin) {
        this.cin = cin;
        return this;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getCv() {
        return cv;
    }

    public Stagiaire cv(String cv) {
        this.cv = cv;
        return this;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getTel() {
        return tel;
    }

    public Stagiaire tel(String tel) {
        this.tel = tel;
        return this;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public Stagiaire email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public Set<DemandeStage> getDemandeStages() {
        return demandeStages;
    }

    public Stagiaire demandeStages(Set<DemandeStage> demandeStages) {
        this.demandeStages = demandeStages;
        return this;
    }

    public Stagiaire addDemandeStage(DemandeStage demandeStage) {
        this.demandeStages.add(demandeStage);
        demandeStage.getStagiaires().add(this);
        return this;
    }

    public Stagiaire removeDemandeStage(DemandeStage demandeStage) {
        this.demandeStages.remove(demandeStage);
        demandeStage.getStagiaires().remove(this);
        return this;
    }

    public void setDemandeStages(Set<DemandeStage> demandeStages) {
        this.demandeStages = demandeStages;
    }

    public Set<DocumentFournis> getSujets() {
        return sujets;
    }

    public Stagiaire sujets(Set<DocumentFournis> documentFournis) {
        this.sujets = documentFournis;
        return this;
    }

    public Stagiaire addSujets(DocumentFournis documentFournis) {
        this.sujets.add(documentFournis);
        documentFournis.getStagiaires().add(this);
        return this;
    }

    public Stagiaire removeSujets(DocumentFournis documentFournis) {
        this.sujets.remove(documentFournis);
        documentFournis.getStagiaires().remove(this);
        return this;
    }

    public void setSujets(Set<DocumentFournis> documentFournis) {
        this.sujets = documentFournis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Stagiaire)) {
            return false;
        }
        return id != null && id.equals(((Stagiaire) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    public Stagiaire() {
    }


    @Override
    public String toString() {
        return "Stagiaire{" +
            "id=" + getId() +
            ", cin='" + getCin() + "'" +
            ", cv='" + getCv() + "'" +
            ", tel='" + getTel() + "'" +
            ", email='" + getEmail() + "'" +
            "}";
    }


}
