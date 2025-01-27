package com.example.Ejercicio2.repository;

import com.example.Ejercicio2.model.Medical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalRepository extends JpaRepository<Medical, Long> {
}
