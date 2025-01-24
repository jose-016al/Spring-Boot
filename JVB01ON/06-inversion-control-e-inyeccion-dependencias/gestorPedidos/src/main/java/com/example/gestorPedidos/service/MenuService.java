package com.example.gestorPedidos.service;

import com.example.gestorPedidos.model.Menu;
import com.example.gestorPedidos.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService implements IMenuService {

    @Autowired
    private RestaurantRepository repository;

    @Override
    public List<Menu> findAll() {
        return repository.findAllDishes();
    }

    @Override
    public String save(Menu dish) {
        repository.saveDish(dish);
        return "Nuevo plato agregado: " + dish.getName();
    }
}
