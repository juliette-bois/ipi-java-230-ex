package com.ipiecoles.java.java230.repository;

import com.ipiecoles.java.java230.model.Manager;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ManagerRepository extends PagingAndSortingRepository<Manager, Long> {
    @EntityGraph(attributePaths = "equipe")
    Manager findWithEquipeById(Long id);
}
