package com.example.gestionstage.controller;

import com.example.gestionstage.domain.TuteurEntreprise;
import com.example.gestionstage.service.TuteurEntrepriseService;
/*import com.example.gestionstage.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/api")
public class TuteurEntrepriseResource {

    private final Logger log = LoggerFactory.getLogger(TuteurEntrepriseResource.class);


    private final TuteurEntrepriseService tuteurEntrepriseService;

    public TuteurEntrepriseResource(TuteurEntrepriseService tuteurEntrepriseService) {
        this.tuteurEntrepriseService = tuteurEntrepriseService;
    }
    @PostMapping("/tuteur-entreprises")
    public TuteurEntreprise createTuteurEntreprise(@Valid @RequestBody TuteurEntreprise tuteurEntreprise){
        TuteurEntreprise result = tuteurEntrepriseService.save(tuteurEntreprise);
        return result;
    }

    @PutMapping("/tuteur-entreprises")
    public ResponseEntity<TuteurEntreprise> updateTuteurEntreprise(@Valid @RequestBody TuteurEntreprise tuteurEntreprise) {
        TuteurEntreprise result = tuteurEntrepriseService.save(tuteurEntreprise);
        return ResponseEntity.ok().body(result);
    }
    @GetMapping("/tuteur-entreprises")
    public ResponseEntity<List<TuteurEntreprise>> getAllTuteurEntreprises(Pageable pageable) {
        Page<TuteurEntreprise> page = tuteurEntrepriseService.findAll(pageable);
        return ResponseEntity.ok().body(page.getContent());
    }
   @GetMapping("/tuteur-entreprises/{id}")
    public Optional<TuteurEntreprise> getTuteurEntreprise(@PathVariable Long id) {
        Optional<TuteurEntreprise> tuteurEntreprise = tuteurEntrepriseService.findOne(id);
        return tuteurEntreprise;
    }

   @DeleteMapping("/tuteur-entreprises/{id}")
    public ResponseEntity<Long> deleteTuteurEntreprise(@PathVariable Long id) {
        log.debug("REST request to delete TuteurEntreprise : {}", id);
        tuteurEntrepriseService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
