package com.example.application.data.repositories;

import com.example.application.data.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
