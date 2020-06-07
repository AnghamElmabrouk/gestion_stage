package com.example.gestionstage.repository;

import com.example.gestionstage.domain.DemandeStage;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DemandeStageRepository extends JpaRepository<DemandeStage, Long> {
    @Query("select distinct ds from DemandeStage ds,Stagiaire s where s.demandeStages.stagiaire_id = :id and s.demandeStages.demande_stage_id= ds.id")
    List<DemandeStage> findAllById(@Param("id") Long id);
}
