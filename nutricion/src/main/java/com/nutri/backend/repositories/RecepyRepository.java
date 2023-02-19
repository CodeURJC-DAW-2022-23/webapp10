package com.nutri.backend.repositories;

import com.nutri.backend.model.Recepy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecepyRepository extends JpaRepository<Recepy,Long> {
    Optional<Recepy> findByName(String name);
    Optional<Recepy> findByDescription(String email);

}
