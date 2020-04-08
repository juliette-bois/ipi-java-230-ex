package com.ipiecoles.java.java230.repository;

import com.ipiecoles.java.java230.model.Employe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EmployeRepository extends PagingAndSortingRepository<Employe, Long> {
    Optional<Employe> findById(long l);
    Optional<Employe> findByMatricule(String matricule);
    List<Employe> findByNomAndPrenom(String name, String prenom);
    List<Employe> findByNomIgnoreCase(String name);
    Page<Employe> findByNomIgnoreCase(String name, Pageable pageable);
    List<Employe> findByDateEmbaucheBefore(LocalDate dateEmbauche);
    List<Employe> findByDateEmbaucheAfter(LocalDate dateEmbauche);
    List<Employe> findBySalaireGreaterThanOrderBySalaire(Double salaire);

    @Query("from Employe e where lower(e.nom) = lower(:nomOUprenom) or lower(e.prenom) = lower(:nomOUprenom) ")
    List<Employe> findByNomOrPrenomAllIgnoreCase(@Param("nomOUprenom") String nomOuPrenom);

    @Query(value = "SELECT * from Employe where salaire > (SELECT avg(e2.salaire) from Employe e2)", nativeQuery = true)
    List<Employe> findEmployePlusRiches();

}