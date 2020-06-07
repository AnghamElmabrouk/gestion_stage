package com.example.gestionstage.repository;

import com.example.gestionstage.domain.Sujet;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


@Repository
public interface SujetRepository extends JpaRepository<Sujet, Long> {
}
