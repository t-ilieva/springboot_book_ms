package com.example.application.data.repositories;

import com.example.application.data.entities.DeactivationReason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeactivationReasonRepository extends JpaRepository<DeactivationReason, Integer> {
}
