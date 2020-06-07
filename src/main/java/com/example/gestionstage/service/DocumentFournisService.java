package com.example.gestionstage.service;

import com.example.gestionstage.domain.DocumentFournis;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface DocumentFournisService {


    DocumentFournis save(DocumentFournis documentFournis);

    List<DocumentFournis> findAll();

    Page<DocumentFournis> findAllWithEagerRelationships(Pageable pageable);


    Optional<DocumentFournis> findOne(Long id);

    void delete(Long id);
}
