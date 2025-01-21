package com.example.Ejercicio3.controller;

import com.example.Ejercicio3.model.Empleado;
import com.example.Ejercicio3.model.Empresa;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/empresas")
@RestController
public class EmpresaController {

    private List<Empresa> empresas = new ArrayList<>();

    @PostMapping
    public String addEmpresa(@RequestBody Empresa empresa) {
        empresas.add(empresa);
        return "Empresa agregada correctamente";
    }

    @GetMapping
    public List<Empresa> findAllEmpresas() {
        return empresas;
    }

    @GetMapping("/{id}")
    public Empresa findEmpresaById(@PathVariable Long id) {
        return empresas.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No se ha encontrado la empresa con ID " + id));
    }

    @GetMapping("/empleados/{id}")
    public List<Empleado> findAllEmpleados(@PathVariable Long id) {
        return findEmpresaById(id).getEmpleados();
    }
}
