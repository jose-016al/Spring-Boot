package com.example.gestorPedidos.model;

import java.util.List;

public class Order {

    private Long id;
    private List<Menu> dishes;
    private double total;

    public Order(Long id, List<Menu> dishes, double total) {
        this.id = id;
        this.dishes = dishes;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public List<Menu> getDishes() {
        return dishes;
    }

    public double getTotal() {
        return total;
    }
}