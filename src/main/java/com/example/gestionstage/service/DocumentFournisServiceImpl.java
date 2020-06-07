package com.example.gestionstage.service;

import com.example.gestionstage.domain.DocumentFournis;
import com.example.gestionstage.repository.DocumentFournisRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentFournisServiceImpl implements DocumentFournisService {

    private final Logger log = LoggerFactory.getLogger(DocumentFournisServiceImpl.class);

    private final DocumentFournisRepository documentFournisRepository;

    public DocumentFournisServiceImpl(DocumentFournisRepository documentFournisRepository) {
        this.documentFournisRepository = documentFournisRepository;
    }

    @Override
    public DocumentFournis save(DocumentFournis documentFournis) {
        log.debug("Request to save DocumentFournis : {}", documentFournis);
        return documentFournisRepository.save(documentFournis);
    }


    @Override
    //@Transactional(readOnly = true)
    public List<DocumentFournis> findAll() {
        log.debug("Request to get all DocumentFournis");
        return documentFournisRepository.findAllWithEagerRelationships();
    }

    public Page<DocumentFournis> findAllWithEagerRelationships(Pageable pageable) {
        return documentFournisRepository.findAllWithEagerRelationships(pageable);
    }

    @Override
    //@Transactional(readOnly = true)
    public Optional<DocumentFournis> findOne(Long id) {
        log.debug("Request to get DocumentFournis : {}", id);
        return documentFournisRepository.findOneWithEagerRelationships(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete DocumentFournis : {}", id);
        documentFournisRepository.deleteById(id);
    }

}
