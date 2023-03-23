package com.nutri.backend.repositories;

import com.nutri.backend.model.Recepy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RecepyRepository extends JpaRepository<Recepy,Long> {
    Optional<Recepy> findByName(String name);
    Optional<Recepy> findByDescription(String email);
    Page<Recepy> findAll(Pageable page);
    @Query(value = "SELECT * FROM recepy WHERE KIND_OF_RECEPY = :kindOfRecepy",nativeQuery = true)
    List<Recepy> findByKindOfRecepy(String kindOfRecepy);

}
