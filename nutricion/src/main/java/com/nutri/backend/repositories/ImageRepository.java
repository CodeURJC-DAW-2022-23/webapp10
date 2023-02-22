package com.nutri.backend.repositories;

import com.nutri.backend.model.Form;
import com.nutri.backend.model.Image;
import com.nutri.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image,Long> {
    Optional<Image> findByName(String name);
}
