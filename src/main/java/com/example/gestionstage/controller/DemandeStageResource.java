package com.example.gestionstage.controller;

import com.example.gestionstage.domain.DemandeStage;
import com.example.gestionstage.domain.Stagiaire;
import com.example.gestionstage.service.DemandeStageService;

import org.apache.tomcat.util.http.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;


@RestController
//@RequestMapping("/api")
public class DemandeStageResource {

    private final Logger log = LoggerFactory.getLogger(DemandeStageResource.class);


    private final DemandeStageService demandeStageService;

    public DemandeStageResource(DemandeStageService demandeStageService) {
        this.demandeStageService = demandeStageService;
    }


    @PostMapping("/demande-stages")
    public DemandeStage createDemandeStage(@RequestBody DemandeStage demandeStage) throws URISyntaxException {
        log.debug("REST request to save DemandeStage : {}", demandeStage);
        DemandeStage result = demandeStageService.save(demandeStage);
        return result;
    }

    @PutMapping("/demande-stages")
    public ResponseEntity<DemandeStage> updateDemandeStage(@RequestBody DemandeStage demandeStage) throws URISyntaxException {
        log.debug("REST request to update DemandeStage : {}", demandeStage);
        DemandeStage result = demandeStageService.save(demandeStage);
        return ResponseEntity.ok()
                .body(result);
    }

    @GetMapping("/demande-stages")
    public ResponseEntity<List<DemandeStage>> getAllDemandeStages(Pageable pageable) {
        log.debug("REST request to get a page of DemandeStages");
        Page<DemandeStage> page = demandeStageService.findAll(pageable);
       return ResponseEntity.ok().body(page.getContent());
    }

    @DeleteMapping("/demande-stages/{id}")
    public ResponseEntity<Long> deleteDemandeStage(@PathVariable Long id) {
        log.debug("REST request to delete DemandeStage : {}", id);
        demandeStageService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);   }
}
