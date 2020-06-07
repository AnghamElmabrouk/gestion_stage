package com.example.gestionstage.service;

import com.example.gestionstage.domain.Sujet;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface SujetService {

    Sujet save(Sujet sujet);

    Page<Sujet> findAll(Pageable pageable);

    Optional<Sujet> findOne(Long id);

    void delete(Long id);
}
