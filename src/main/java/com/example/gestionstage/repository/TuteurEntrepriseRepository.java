package com.example.gestionstage.repository;

import com.example.gestionstage.domain.TuteurEntreprise;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


@Repository
public interface TuteurEntrepriseRepository extends JpaRepository<TuteurEntreprise, Long> {
}
