package com.example.gestorPedidos.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Menu {
    private Long id;
    private String name;
    private String description;
    private double price;
}