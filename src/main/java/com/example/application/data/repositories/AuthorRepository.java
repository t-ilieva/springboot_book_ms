package com.example.application.data.repositories;

import com.example.application.data.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    //@Query("SELECT a FROM author a WHERE a.first_name = :first_name and a.last_name = :last_name")
    //Author findByName(@Param("first_name") String firstName, @Param("last_name") String lastName);
}
