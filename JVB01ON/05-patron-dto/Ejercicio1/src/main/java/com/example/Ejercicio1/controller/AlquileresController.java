package com.example.Ejercicio1.controller;

import com.example.Ejercicio1.dto.PropiedadDTO;
import com.example.Ejercicio1.modal.Inquilino;
import com.example.Ejercicio1.modal.Propiedad;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlquileresController {

    @GetMapping("/{id}")
    public PropiedadDTO getPropiedad(@PathVariable Long id) {
        Propiedad propiedad = new Propiedad(1L, "Apartamento", "Calle Principal 123, Ciudad", 75.5, 1200.0);
        Inquilino inquilino = new Inquilino(1L, "12345678A", "Juan", "Pérez", "Ingeniero");

        PropiedadDTO propiedadDTO = new PropiedadDTO();

        propiedadDTO.setId(propiedad.getId());
        propiedadDTO.setTipo(propiedad.getTipo());
        propiedadDTO.setDireccion(propiedad.getDireccion());
        propiedadDTO.setValorAlquiler(propiedad.getValorAlquiler());
        propiedadDTO.setNombre(inquilino.getNombre());
        propiedadDTO.setApellido(inquilino.getApellido());

        return propiedadDTO;
    }
}
