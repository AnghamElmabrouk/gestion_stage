package com.example.gestionstage.service;

import com.example.gestionstage.domain.DemandeStage;
import com.example.gestionstage.domain.Stagiaire;
import com.example.gestionstage.repository.DemandeStageRepository;
import com.example.gestionstage.repository.StagiaireRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class StagiaireServiceImpl implements StagiaireService{
    private final Logger log = LoggerFactory.getLogger(StagiaireServiceImpl.class);

    private final StagiaireRepository stagiaireRepository;

    @Autowired
    private SendEmailService sendEmailService;

    @Autowired
    private DemandeStageRepository demandeStageRepository;

    public StagiaireServiceImpl(StagiaireRepository stagiaireRepository) {
        this.stagiaireRepository = stagiaireRepository;
    }

    public void addDemande(Stagiaire stagiaire){
        sendEmailService.sendEmail(stagiaire);
        DemandeStage demandeStage = new DemandeStage();
        demandeStage.setDateCreation(new Date());
        demandeStage.setEtatDemande("Created");
        //Set<DemandeStage> demandeStages =new HashSet<>();
        demandeStage.getStagiaires().add(stagiaire);
        //demandeStages.add(demandeStage);
        stagiaire.getDemandeStages().add(demandeStage);
        //stagiaire.setDemandeStages(demandeStages);
        demandeStageRepository.save(demandeStage);
    }
    /**
     * Save a stagiaire.
     *
     * @param stagiaire the entity to save.
     * @return the persisted entity.
     */
    @Override
    public Stagiaire save(Stagiaire stagiaire) {
        log.debug("Request to save Stagiaire : {}", stagiaire);
        Stagiaire stagiaire1 = this.findByEmail(stagiaire.getEmail());
        if(stagiaire1 != null){
           this.addDemande(stagiaire1);
           return stagiaire1;

        }else{
            this.addDemande(stagiaire);
            return stagiaireRepository.saveAndFlush(stagiaire);

        }



    }

    /**
     * Get all the stagiaires.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<Stagiaire> findAll(Pageable pageable) {
        log.debug("Request to get all Stagiaires");
        return stagiaireRepository.findAll(pageable);
    }

    /**
     * Get all the stagiaires with eager load of many-to-many relationships.
     *
     * @return the list of entities.
     */
    public Page<Stagiaire> findAllWithEagerRelationships(Pageable pageable) {
        return stagiaireRepository.findAllWithEagerRelationships(pageable);
    }

    /**
     * Get one stagiaire by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Stagiaire> findOne(Long id) {
        log.debug("Request to get Stagiaire : {}", id);

        return stagiaireRepository.findOneWithEagerRelationships(id);
    }

    /**
     * Delete the stagiaire by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Stagiaire : {}", id);
        stagiaireRepository.deleteById(id);
    }

    @Override
    public Stagiaire findByEmail(String email) {
        return stagiaireRepository.findByEmail(email);
    }

    @Override
    public Stagiaire findByCin(String cin) {
        return stagiaireRepository.findByCin(cin);
    }

    @Override
    public List<Stagiaire> findAllWithEagerRelationship() {
        return stagiaireRepository.findAllWithEagerRelationship();
    }
}
