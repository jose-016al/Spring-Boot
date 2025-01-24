package com.example.Ejercicio2.service;

import com.example.Ejercicio2.dto.PlatoDTO;
import com.example.Ejercicio2.model.Ingrediente;
import com.example.Ejercicio2.model.Plato;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PlatoService implements IPlatoService {

    private List<Plato> platos = Arrays.asList(
            new Plato(1L, "Pizza Margarita", 8.50, Arrays.asList(
                    new Ingrediente(1L, "Harina de trigo", false),
                    new Ingrediente(3L, "Azúcar", true),
                    new Ingrediente(4L, "Levadura", false),
                    new Ingrediente(5L, "Aceite de oliva", true)
            )),
            new Plato(2L, "Ensalada César", 10.00, Arrays.asList(
                    new Ingrediente(5L, "Aceite de oliva", true),
                    new Ingrediente(3L, "Azúcar", true),
                    new Ingrediente(2L, "Harina de maíz", true)
            )),
            new Plato(3L, "Tarta de Maíz", 6.75, Arrays.asList(
                    new Ingrediente(2L, "Harina de maíz", true),
                    new Ingrediente(3L, "Azúcar", true),
                    new Ingrediente(5L, "Aceite de oliva", true)
            ))
    );

    @Override
    public List<Plato> findAll() {
        return platos;
    }

    @Override
    public String save(Plato plato) {
        platos.add(plato);
        return "Plato añadido correctamente";
    }

    @Override
    public Plato findById(Long id) {
        return platos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Plato no encontrado"));
    }

    @Override
    public List<Plato> findCeliacos() {
        return platos.stream()
                .filter(plato -> plato.getIngredientes().stream()
                        .allMatch(Ingrediente::isAptoCeliaco)
                )
                .toList();
    }

    @Override
    public PlatoDTO findCeliacosById(Long id) {
        return platos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .map(plato -> new PlatoDTO(
                                plato.getNombre(),
                                plato.getIngredientes().stream().allMatch(Ingrediente::isAptoCeliaco) ? "Si" : "No"
                        )
                )
                .orElseThrow(() -> new IllegalArgumentException("Plato no encontrado"));
    }
}
