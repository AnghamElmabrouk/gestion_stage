package com.example.gestionstage.service;

import com.example.gestionstage.domain.TuteurEntreprise;
import com.example.gestionstage.repository.TuteurEntrepriseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TuteurEntrepriseServiceImpl implements TuteurEntrepriseService{
    private final Logger log = LoggerFactory.getLogger(TuteurEntrepriseServiceImpl.class);

    private final TuteurEntrepriseRepository tuteurEntrepriseRepository;

    public TuteurEntrepriseServiceImpl(TuteurEntrepriseRepository tuteurEntrepriseRepository) {
        this.tuteurEntrepriseRepository = tuteurEntrepriseRepository;
    }

    /**
     * Save a tuteurEntreprise.
     *
     * @param tuteurEntreprise the entity to save.
     * @return the persisted entity.
     */
    @Override
    public TuteurEntreprise save(TuteurEntreprise tuteurEntreprise) {
        log.debug("Request to save TuteurEntreprise : {}", tuteurEntreprise);
        return tuteurEntrepriseRepository.save(tuteurEntreprise);
    }

    /**
     * Get all the tuteurEntreprises.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<TuteurEntreprise> findAll(Pageable pageable) {
        log.debug("Request to get all TuteurEntreprises");
        return tuteurEntrepriseRepository.findAll(pageable);
    }

    /**
     * Get one tuteurEntreprise by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<TuteurEntreprise> findOne(Long id) {
        log.debug("Request to get TuteurEntreprise : {}", id);
        return tuteurEntrepriseRepository.findById(id);
    }

    /**
     * Delete the tuteurEntreprise by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete TuteurEntreprise : {}", id);
        tuteurEntrepriseRepository.deleteById(id);
    }
}
