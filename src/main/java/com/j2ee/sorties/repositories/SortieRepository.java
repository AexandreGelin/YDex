package com.j2ee.sorties.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.j2ee.sorties.entities.Sortie;

@Repository
public interface SortieRepository extends JpaRepository<Sortie, Long> {
}
