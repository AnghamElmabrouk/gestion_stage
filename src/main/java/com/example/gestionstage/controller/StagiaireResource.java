package com.example.gestionstage.controller;

import com.example.gestionstage.domain.DemandeStage;
import com.example.gestionstage.domain.Stagiaire;
import com.example.gestionstage.repository.DemandeStageRepository;
import com.example.gestionstage.service.SendEmailService;
import com.example.gestionstage.service.StagiaireService;

/*import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;*/

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
//@RequestMapping("/api")
public class StagiaireResource {

    private final Logger log = LoggerFactory.getLogger(StagiaireResource.class);

    @Autowired
    private SendEmailService sendEmailService;

    @Autowired
    private DemandeStageRepository demandeStageRepository;

    private final StagiaireService stagiaireService;

    public StagiaireResource(StagiaireService stagiaireService) {
        this.stagiaireService = stagiaireService;
    }

   /* @PostMapping("/webhook")
    public void testWebhook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(request);

       // System.out.println(request.getContextPath());
        System.out.println(request.getHeaders("cin"));
        System.out.println(request.getHeader("cin"));
        System.out.println("cin" +request.getParameterValues("cin"));

        String cin = request.getParameter("cin");
        System.out.println(cin);
        String cv = request.getParameter("cv");
        System.out.println(cv);
        String telephone_number = request.getParameter("telephone_number");
        System.out.println(telephone_number);
        String email = request.getParameter("email");
        System.out.println(email);

        final StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = request.getReader()) {
            if (reader == null) {
                // return null;
            }
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            System.out.println("result" +builder.toString());
            JSONObject jsonObj = new JSONObject(builder.toString());
            System.out.println("jsonobj" +jsonObj);

            Stagiaire stagiaire = new Stagiaire();
            stagiaire.setCin(jsonObj.get("cin").toString());
            stagiaire.setCv(jsonObj.get("cv").toString());
            stagiaire.setTel(jsonObj.get("telephone_number").toString());
            stagiaire.setEmail(jsonObj.get("email").toString());
            stagiaireService.save(stagiaire);



        } catch (final Exception e) {
            //return null;
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        JSONObject result = new JSONObject("{Can you send me the code to verify your email?: Thank you}");
        PrintWriter out = response.getWriter();
// Assuming your json object is **jsonObject**, perform the following, it will return your json object
        out.print(result);
        out.flush();
        //  return result;
    }*/

    @PostMapping("/stagiairess")
    public Stagiaire createStagiaire(@Valid @RequestBody Stagiaire stagiaire) {
        Stagiaire result = stagiaireService.save(stagiaire);
        sendEmailService.sendEmail(stagiaire);
        return result;
    }

    /*@PostMapping("/verifyotp")
    public void verifyotp(@RequestParam String otp){
        //  if(sendEmailService.sendEmail())
    }*/
    @PostMapping("/verifyotp")
    public void verifyotp(@RequestParam String otp){
        //  if(sendEmailService.sendEmail())
    }

    @PostMapping("/createstagiaire")
    public Stagiaire newStagiaire(@RequestParam("cin") String cin, @RequestParam("cv") String cv, @RequestParam("email") String email, @RequestParam("telephone_number") String telephone_number) {

        System.out.println("******************");
        System.out.println(cin);
        System.out.println(cv);
        System.out.println(email);
        System.out.println(telephone_number);
        System.out.println("******************");

        Stagiaire stagiaire = new Stagiaire();
        stagiaire.setCin(cin);
        stagiaire.setCv(cv);
        stagiaire.setEmail(email);
        stagiaire.setTel(telephone_number);
        Stagiaire result = stagiaireService.save(stagiaire);


        return result;
    }



    @GetMapping("/stagiairespar")
    public List<Stagiaire> getDemandeStages(){
        return stagiaireService.findAllWithEagerRelationship();
    }



    @GetMapping("/hello")
    public String test() {
        return "hello";
    }

    @GetMapping(value="/item", produces= MediaType.APPLICATION_JSON_VALUE)
    public String testfunction() {
        return "hi";
    }


    @PostMapping("/stagiaires")
    public ResponseEntity<Stagiaire> updateStagiaire(@Valid @RequestBody Stagiaire stagiaire){
        log.debug("REST request to update Stagiaire : {}", stagiaire);
        Stagiaire result = stagiaireService.save(stagiaire);
        return ResponseEntity.ok().body(result);
    }


    @GetMapping("/stagiaires")
    public ResponseEntity<List<Stagiaire>> getAllStagiaires(Pageable pageable, @RequestParam(required = false, defaultValue = "false") boolean eagerload) {
        log.debug("REST request to get a page of Stagiaires");
        Page<Stagiaire> page;
        if (eagerload) {
            page = stagiaireService.findAllWithEagerRelationships(pageable);
       } else {
            page = stagiaireService.findAll(pageable);
       }
        return ResponseEntity.ok()
            .body(page.getContent());
    }


/*    @GetMapping("/stagiaires/email/{email}")
    public List<Stagiaire> findByEmail(@PathVariable  String email){
        return stagiaireService.findByEmail(email);

    }*/
/*    @GetMapping("/stagiaires/email/{email}")
    public Set<DemandeStage> find(@PathVariable String email){
        Stagiaire stagiaire= stagiaireService.findByEmail(email);
        return stagiaire.getDemandeStages();
    }*/

    @GetMapping("/stagiaires/email/{email}")
    public Stagiaire find(@PathVariable String email){
        return this.stagiaireService.findByEmail(email);

    }

    @GetMapping("/stagiaires/cin/{cin}")
    public String findbycin(@PathVariable String cin){
        Stagiaire stagiaire= stagiaireService.findByCin(cin);
        return stagiaire.getOtp();

    }

   @GetMapping("/stagiaires/{id}")
    public Optional<Stagiaire> getStagiaire(@PathVariable Long id) {
        log.debug("REST request to get Stagiaire : {}", id);
        Optional<Stagiaire> stagiaire = stagiaireService.findOne(id);
        return stagiaire;
    }

    @DeleteMapping("/stagiaires/{id}")
    public ResponseEntity<Long> deleteStagiaire(@PathVariable Long id) {
        log.debug("REST request to delete Stagiaire : {}", id);
        stagiaireService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/getDemande")
    public List<DemandeStage> getDemandeById(@RequestParam String email){
        Stagiaire stagiaire = this.find(email);
        return this.demandeStageRepository.findAllById(Collections.singleton(stagiaire.getId()));
    }


}
