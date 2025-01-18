package com.example.gestorPedidos.controller;

import com.example.gestorPedidos.model.Menu;
import com.example.gestorPedidos.model.Order;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    List<Menu> dishes = new ArrayList<>();
    List<Order> orders = new ArrayList<>();

    @GetMapping("/menu")
    public @ResponseBody List<Menu> getMenu() {
        return dishes;
    }

    @PostMapping("/menu/add")
    public String addCourse (@RequestBody Menu newCourse) {
        dishes.add(newCourse);
        return "Nuevo plato agregado: " + newCourse.getName();
    }

    @GetMapping("/order/{id}")
    public @ResponseBody Order getOrder(@PathVariable Long id) {
        return orders.stream()
                .filter(order -> order.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Pedido no encontrado"));
    }

    @PostMapping("/order/add")
    public String addOrder(@RequestParam Long id, @RequestParam List<Long> dishesId) {
        List<Menu> dishesByIds = dishesId.stream()
                .map(dishId -> dishes.stream()
                        .filter(menu -> menu.getId().equals(dishId))
                        .findFirst()
                        .orElseThrow(() -> new IllegalArgumentException("Plato no encontrado"))
                )
                .toList();

        double total = dishesByIds.stream()
                .mapToDouble(Menu::getPrice)
                .sum();
        orders.add(new Order(id, dishesByIds, total));
        return "Pedido realizado";
    }

}