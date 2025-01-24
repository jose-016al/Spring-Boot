package com.example.gestorPedidos.service;

import com.example.gestorPedidos.dto.OrderDTO;
import com.example.gestorPedidos.model.Menu;
import com.example.gestorPedidos.model.Order;
import com.example.gestorPedidos.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private RestaurantRepository repository;

    @Override
    public OrderDTO findById(Long id) {
        return repository.findByIdOrder(id)
                .map(order -> new OrderDTO(
                        order.getId(),
                        order.getTotal()
                ))
                .orElse(null);
    }

    @Override
    public String save(Order order) {
        repository.saveOrder(order);
        return "Pedido realizado";
    }
}
