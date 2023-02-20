package com.nutri.backend.repositories;

import com.nutri.backend.model.Diet;
import com.nutri.backend.model.Triplet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DietRepository extends JpaRepository<Diet, Long> {
     Optional<Diet> findByName(String name);
     Optional<Diet> findByType(String type);

     @Query(value = "SELECT COUNT(*) FROM DIET",nativeQuery = true)
     int numOfDiets();
     @Query(value = "SELECT NAME FROM DIET ",nativeQuery = true)
     List<String> findOnlyName();

     @Query(value = "SELECT WEEK FROM DIET ",nativeQuery = true)
     List<Triplet> findOnlyWeek();

}
