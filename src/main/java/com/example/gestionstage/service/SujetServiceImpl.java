package com.example.gestionstage.service;

import com.example.gestionstage.domain.Sujet;
import com.example.gestionstage.repository.StageRepository;
import com.example.gestionstage.repository.SujetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class SujetServiceImpl implements SujetService{
    private final Logger log = LoggerFactory.getLogger(SujetServiceImpl.class);

    private final SujetRepository sujetRepository;

    @Autowired
    private StageRepository stageRepository;

    public SujetServiceImpl(SujetRepository sujetRepository) {
        this.sujetRepository = sujetRepository;
    }

    /**
     * Save a sujet.
     *
     * @param sujet the entity to save.
     * @return the persisted entity.
     */
    @Override
    public Sujet save(Sujet sujet) {
        log.debug("Request to save Sujet : {}", sujet);
        return sujetRepository.save(sujet);
    }

    /**
     * Get all the sujets.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<Sujet> findAll(Pageable pageable) {
        log.debug("Request to get all Sujets");
        return sujetRepository.findAll(pageable);
    }

    /**
     * Get one sujet by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Sujet> findOne(Long id) {
        log.debug("Request to get Sujet : {}", id);
        return sujetRepository.findById(id);
    }

    /**
     * Delete the sujet by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Sujet : {}", id);
        sujetRepository.deleteById(id);
    }
}
