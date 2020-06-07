package com.example.gestionstage.controller;

import com.example.gestionstage.domain.DocumentFournis;
import com.example.gestionstage.service.DocumentFournisService;


/*import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
//@RequestMapping("/api")
public class DocumentFournisResource {

    private final Logger log = LoggerFactory.getLogger(DocumentFournisResource.class);

    private final DocumentFournisService documentFournisService;

    public DocumentFournisResource(DocumentFournisService documentFournisService) {
        this.documentFournisService = documentFournisService;
    }


    @PostMapping("/document-fournis")
    public DocumentFournis createDocumentFournis(@RequestBody DocumentFournis documentFournis) throws URISyntaxException {
        log.debug("REST request to save DocumentFournis : {}", documentFournis);
        DocumentFournis result = documentFournisService.save(documentFournis);
        return result;
    }

    @PutMapping("/document-fournis")
    public ResponseEntity<DocumentFournis> updateDocumentFournis(@RequestBody DocumentFournis documentFournis) throws URISyntaxException {
        log.debug("REST request to update DocumentFournis : {}", documentFournis);
        DocumentFournis result = documentFournisService.save(documentFournis);
        return ResponseEntity.ok()
           // .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, documentFournis.getId().toString()))
            .body(result);
    }

    @GetMapping("/document-fournis")
    public List<DocumentFournis> getAllDocumentFournis(@RequestParam(required = false, defaultValue = "false") boolean eagerload) {
        log.debug("REST request to get all DocumentFournis");
        return documentFournisService.findAll();
    }


    /*@DeleteMapping("/document-fournis/{id}")
    public ResponseEntity<Void> deleteDocumentFournis(@PathVariable Long id) {
        log.debug("REST request to delete DocumentFournis : {}", id);
        documentFournisService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }*/
}
