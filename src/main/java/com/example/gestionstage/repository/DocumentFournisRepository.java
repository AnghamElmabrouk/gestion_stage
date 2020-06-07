package com.example.gestionstage.repository;

import com.example.gestionstage.domain.DocumentFournis;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DocumentFournisRepository extends JpaRepository<DocumentFournis, Long> {

    @Query(value = "select distinct documentFournis from DocumentFournis documentFournis left join fetch documentFournis.sujets left join fetch documentFournis.stagiaires",
        countQuery = "select count(distinct documentFournis) from DocumentFournis documentFournis")
    Page<DocumentFournis> findAllWithEagerRelationships(Pageable pageable);

    @Query("select distinct documentFournis from DocumentFournis documentFournis left join fetch documentFournis.sujets left join fetch documentFournis.stagiaires")
    List<DocumentFournis> findAllWithEagerRelationships();

    @Query("select documentFournis from DocumentFournis documentFournis left join fetch documentFournis.sujets left join fetch documentFournis.stagiaires where documentFournis.id =:id")
    Optional<DocumentFournis> findOneWithEagerRelationships(@Param("id") Long id);
}
