package com.example.gestionstage.repository;

import com.example.gestionstage.domain.Stage;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


@Repository
public interface StageRepository extends JpaRepository<Stage, Long> {
}
