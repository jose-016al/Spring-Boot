package com.example.gestorPedidos.repository;

import com.example.gestorPedidos.model.Menu;
import com.example.gestorPedidos.model.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RestaurantRepository {

    List<Menu> dishes = new ArrayList<>();
    List<Order> orders = new ArrayList<>();

        // Menu
    public List<Menu> findAllDishes() {
        return dishes;
    }

    public void saveDish(Menu dish) {
        dishes.add(dish);
    }

        // Order
    public Optional<Order> findByIdOrder(Long id) {
        return orders.stream()
                .filter(order -> order.getId().equals(id))
                .findFirst();
    }

    public void saveOrder(Order order) {
        orders.add(order);
    }
}
