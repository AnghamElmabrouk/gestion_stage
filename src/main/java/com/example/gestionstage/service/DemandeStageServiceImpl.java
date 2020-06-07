package com.example.gestionstage.service;

import com.example.gestionstage.domain.DemandeStage;
import com.example.gestionstage.domain.Stagiaire;
import com.example.gestionstage.repository.DemandeStageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DemandeStageServiceImpl implements DemandeStageService{

    private final Logger log = LoggerFactory.getLogger(DemandeStageServiceImpl.class);

    private final DemandeStageRepository demandeStageRepository;

    public DemandeStageServiceImpl(DemandeStageRepository demandeStageRepository) {
        this.demandeStageRepository = demandeStageRepository;
    }

    /**
     * Save a demandeStage.
     *
     * @param demandeStage the entity to save.
     * @return the persisted entity.
     */
    @Override
    public DemandeStage save(DemandeStage demandeStage) {
        log.debug("Request to save DemandeStage : {}", demandeStage);
        demandeStage.setDateCreation(new Date());
        //Stagiaire stagiaire = new Stagiaire();
       // demandeStage.getStagiaires().add(stagiaire);
        return demandeStageRepository.save(demandeStage);
    }

    /**
     * Get all the demandeStages.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<DemandeStage> findAll(Pageable pageable) {
        log.debug("Request to get all DemandeStages");
        return demandeStageRepository.findAll(pageable);
    }

    /**
     * Get one demandeStage by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<DemandeStage> findOne(Long id) {
        log.debug("Request to get DemandeStage : {}", id);
        return demandeStageRepository.findById(id);
    }

    /**
     * Delete the demandeStage by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete DemandeStage : {}", id);
        demandeStageRepository.deleteById(id);
    }


}
