package com.example.gestionstage.repository;

import com.example.gestionstage.domain.Stagiaire;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface StagiaireRepository extends JpaRepository<Stagiaire, Long> {

    //@Query("select p from Stagiaire e where e.email like :x")
    public Stagiaire findByEmail(String email);

    public Stagiaire findByCin(String cin);

    @Query(value = "select distinct stagiaire from Stagiaire stagiaire left join fetch stagiaire.demandeStages",
        countQuery = "select count(distinct stagiaire) from Stagiaire stagiaire")
    Page<Stagiaire> findAllWithEagerRelationships(Pageable pageable);

    @Query("select distinct stagiaire from Stagiaire stagiaire left join fetch stagiaire.demandeStages")
    List<Stagiaire> findAllWithEagerRelationship();

    @Query("select stagiaire from Stagiaire stagiaire left join fetch stagiaire.demandeStages where stagiaire.id =:id")
    Optional<Stagiaire> findOneWithEagerRelationships(@Param("id") Long id);
}
