package com.example.gestionstage.service;

import com.example.gestionstage.domain.Stagiaire;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface StagiaireService {

    Stagiaire save(Stagiaire stagiaire);

    Page<Stagiaire> findAll(Pageable pageable);

    Page<Stagiaire> findAllWithEagerRelationships(Pageable pageable);

    Optional<Stagiaire> findOne(Long id);

    void delete(Long id);

    Stagiaire findByEmail(String email);
    Stagiaire findByCin(String cin);

    List<Stagiaire> findAllWithEagerRelationship();
}
