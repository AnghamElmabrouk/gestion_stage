package com.example.gestionstage.service;

import com.example.gestionstage.domain.Stage;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface StageService {

    Stage save(Stage stage);

    Page<Stage> findAll(Pageable pageable);

    Optional<Stage> findOne(Long id);

    void delete(Long id);
}
