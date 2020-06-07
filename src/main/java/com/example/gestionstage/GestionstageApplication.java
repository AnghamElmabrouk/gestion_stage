package com.example.gestionstage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

//@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})//bypass this spring boot security mechanism.
//@SpringBootApplication
//@ComponentScan(basePackages = {"com.example.gestionstage.model"})
//@ComponentScan
//@EnableAutoConfiguration
@SpringBootApplication
public class GestionstageApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionstageApplication.class, args);
    }

}
