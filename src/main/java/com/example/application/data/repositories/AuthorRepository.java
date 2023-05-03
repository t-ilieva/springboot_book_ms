package com.example.application.data.repositories;

import com.example.application.data.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @Query(value = "SELECT * FROM author a WHERE a.first_name = :first_name and a.last_name = :last_name", nativeQuery = true)
    Optional<Author> findByName(@Param("first_name") String firstName, @Param("last_name") String lastName);

    //Optional<Author> findByName(String first_name, String last_name);

}
