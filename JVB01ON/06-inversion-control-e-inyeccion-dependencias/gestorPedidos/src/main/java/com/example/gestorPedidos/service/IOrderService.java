package com.example.gestorPedidos.service;

import com.example.gestorPedidos.dto.OrderDTO;
import com.example.gestorPedidos.model.Order;

public interface IOrderService {
    public OrderDTO findById(Long id);
    public String save(Order order);
}
