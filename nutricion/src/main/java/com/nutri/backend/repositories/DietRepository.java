package com.nutri.backend.repositories;

import com.nutri.backend.model.Diet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DietRepository extends JpaRepository<Diet, Long> {
     Optional<Diet> findByName(String name);
     Optional<Diet> findByType(String type);


}
