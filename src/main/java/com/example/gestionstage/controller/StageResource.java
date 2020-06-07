package com.example.gestionstage.controller;

import com.example.gestionstage.domain.Stage;
import com.example.gestionstage.service.StageService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/api")
public class StageResource {

    private final Logger log = LoggerFactory.getLogger(StageResource.class);


    private final StageService stageService;

    public StageResource(StageService stageService) {
        this.stageService = stageService;
    }

    @PostMapping("/stages")
    public Stage createStage(@Valid @RequestBody Stage stage){
        Stage result = stageService.save(stage);
        return result;
    }

    @PutMapping("/stages")
    public ResponseEntity<Stage> updateStage(@Valid @RequestBody Stage stage) throws URISyntaxException {
        log.debug("REST request to update Stage : {}", stage);
        Stage result = stageService.save(stage);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/stages")
    public ResponseEntity<List<Stage>> getAllStages(Pageable pageable) {
        log.debug("REST request to get a page of Stages");
        Page<Stage> page = stageService.findAll(pageable);
        return ResponseEntity.ok().body(page.getContent());
    }

    @GetMapping("/stages/{id}")
    public Optional<Stage> getStage(@PathVariable Long id) {
        log.debug("REST request to get Stage : {}", id);
        Optional<Stage> stage = stageService.findOne(id);
        return stage;
    }

   @DeleteMapping("/stages/{id}")
    public ResponseEntity<Long> deleteStage(@PathVariable Long id) {
        log.debug("REST request to delete Stage : {}", id);
        stageService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
