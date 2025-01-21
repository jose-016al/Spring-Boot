package com.example.Ejercicio3.controller;

import com.example.Ejercicio3.service.OrdenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrdenController {

    private OrdenService ordenService = new OrdenService();

    /* @PostMapping
    public List<String> ordenarNombres(@RequestBody List<String> listaNombres) {
        return ordenService.ordenarNombres(listaNombres);
    } */

    @PostMapping
    public ResponseEntity<List<String>> ordenarNombres(@RequestBody List<String> listaNombres) {
        List<String> listaOrdenada = ordenService.ordenarNombres(listaNombres);
        return new ResponseEntity<>(listaOrdenada, HttpStatus.OK);
    }

}
