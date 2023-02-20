package com.nutri.backend.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nutri.backend.model.User;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByName(String name);
    Optional<User> findByEmail(String email);
    List<User> findByUserType(String userType);
    boolean existsByEmail(String foo);
    @Query(value = "SELECT COUNT(*) FROM USER_TABLE WHERE ENTRY_DATE= :date",nativeQuery = true)
    int findByEntryDate( int date);
    @Query(value = "SELECT COUNT(*) FROM USER_TABLE WHERE USER_TYPE= :typeOfUser",nativeQuery = true)
    int findAllByuser(String typeOfUser);
    Page<User> findByUserType(Pageable page,String userType);

}
