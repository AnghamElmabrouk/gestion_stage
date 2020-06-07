package com.example.gestionstage.service;

import com.example.gestionstage.domain.DemandeStage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface DemandeStageService {

    DemandeStage save(DemandeStage demandeStage);

    Page<DemandeStage> findAll(Pageable pageable);

    Optional<DemandeStage> findOne(Long id);

    void delete(Long id);
}
