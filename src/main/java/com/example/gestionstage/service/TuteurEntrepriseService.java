package com.example.gestionstage.service;

import com.example.gestionstage.domain.TuteurEntreprise;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface TuteurEntrepriseService {

    TuteurEntreprise save(TuteurEntreprise tuteurEntreprise);

    Page<TuteurEntreprise> findAll(Pageable pageable);

    Optional<TuteurEntreprise> findOne(Long id);

    void delete(Long id);
}
