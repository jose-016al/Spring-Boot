package com.example.gestorPedidos.controller;

import com.example.gestorPedidos.dto.OrderDTO;
import com.example.gestorPedidos.model.Menu;
import com.example.gestorPedidos.model.Order;
import com.example.gestorPedidos.service.IMenuService;
import com.example.gestorPedidos.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private IMenuService menuService;

    @Autowired
    private IOrderService orderService;

    @GetMapping("/menu")
    public List<Menu> findAll() {
        return menuService.findAll();
    }

    @PostMapping("/menu/add")
    public String save(@RequestBody Menu dish) {
        return menuService.save(dish);
    }

    @GetMapping("/order/{id}")
    public OrderDTO findByIdOrder(@PathVariable Long id) {
        return orderService.findById(id);
    }

    @PostMapping("/order/add")
    public String saveOrder(@RequestBody Order order) {
        return orderService.save(order);
    }

}