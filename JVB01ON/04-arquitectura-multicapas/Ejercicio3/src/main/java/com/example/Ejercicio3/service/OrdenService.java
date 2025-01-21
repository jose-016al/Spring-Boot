package com.example.Ejercicio3.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenService implements IOrdenService {

    @Override
    public List<String> ordenarNombres(List<String> listaNombres) {
        return listaNombres.stream()
                .sorted()
                .toList();
    }
}
