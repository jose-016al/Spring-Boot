package com.example.Ejercicio2.repository;

import com.example.Ejercicio2.model.Ingrediente;
import com.example.Ejercicio2.model.Plato;
import com.example.Ejercicio2.service.PlatoService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class PlatoRepository {

    // private List<Plato> platos = new ArrayList<>();
    private List<Plato> platos = Arrays.asList(
            new Plato(1L, "Pizza Margarita", 8.50, Arrays.asList(
                    new Ingrediente(1L, "Harina de trigo", "No"),
                    new Ingrediente(3L, "Azúcar", "Si"),
                    new Ingrediente(4L, "Levadura", "No"),
                    new Ingrediente(5L, "Aceite de oliva", "Si")
            )),
            new Plato(2L, "Ensalada César", 10.00, Arrays.asList(
                    new Ingrediente(5L, "Aceite de oliva", "Si"),
                    new Ingrediente(3L, "Azúcar", "Si"),
                    new Ingrediente(2L, "Harina de maíz", "Si")
            )),
            new Plato(3L, "Tarta de Maíz", 6.75, Arrays.asList(
                    new Ingrediente(2L, "Harina de maíz", "Si"),
                    new Ingrediente(3L, "Azúcar", "Si"),
                    new Ingrediente(5L, "Aceite de oliva", "Si")
            ))
    );

    public List<Plato> findAll() {
        return platos;
    }

    public void save(Plato plato) {
        platos.add(plato);
    }

    public Optional<Plato> findById(Long id) {
        return platos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public List<Plato> findCeliacos() {
        return platos.stream()
                .filter(plato -> plato.getIngredientes().stream()
                        .allMatch(ingrediente -> ingrediente.getAptoCeliaco().equalsIgnoreCase("Si"))
                )
                .toList();
    }

    public Optional<Plato> findCeliacosById(Long id) {
        return findCeliacos().stream()
                .filter(plato -> plato.getId().equals(id))
                .findFirst();
    }

}
