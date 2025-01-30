package com.example.Ejercicio5.repository;

import com.example.Ejercicio5.modal.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

    // @Query("SELECT p FROM Persona p WHERE p.nombre = :nombre")
    // @Query(value = "SELECT * FROM personas WHERE nombre = :nombre", nativeQuery = true)
    // Optional<Persona> findByNombre(@Param("nombre") String nombre);
    Optional<Persona> findByNombre(String nombre);
}