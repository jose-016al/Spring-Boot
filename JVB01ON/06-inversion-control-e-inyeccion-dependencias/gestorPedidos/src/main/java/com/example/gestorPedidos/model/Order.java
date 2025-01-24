package com.example.gestorPedidos.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Order {
    private Long id;
    private List<Menu> dishes;
    private double total;
}