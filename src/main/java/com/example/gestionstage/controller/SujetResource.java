package com.example.gestionstage.controller;

import com.example.gestionstage.domain.Sujet;
import com.example.gestionstage.service.SujetService;

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
public class SujetResource {

    private final Logger log = LoggerFactory.getLogger(SujetResource.class);

    private final SujetService sujetService;

    public SujetResource(SujetService sujetService) {
        this.sujetService = sujetService;
    }

    @PostMapping("/sujets")
    public Sujet createSujet(@Valid @RequestBody Sujet sujet) {
        Sujet result = sujetService.save(sujet);
        return result;
    }

    @PutMapping("/sujets")
    public ResponseEntity<Sujet> updateSujet(@Valid @RequestBody Sujet sujet) {
        Sujet result = sujetService.save(sujet);
        return ResponseEntity.ok()
            .body(result);
    }

    @GetMapping("/sujets")
    public ResponseEntity<List<Sujet>> getAllSujets(Pageable pageable) {
        Page<Sujet> page = sujetService.findAll(pageable);
        return ResponseEntity.ok().body(page.getContent());
    }

    @GetMapping("/sujets/{id}")
    public Optional<Sujet> getSujet(@PathVariable Long id) {
        Optional<Sujet> sujet = sujetService.findOne(id);
        return sujet;
    }

    @DeleteMapping("/sujets/{id}")
    public ResponseEntity<Long> deleteSujet(@PathVariable Long id) {
        sujetService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
