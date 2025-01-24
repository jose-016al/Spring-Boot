package com.example.gestorPedidos.service;

import com.example.gestorPedidos.model.Menu;

import java.util.List;

public interface IMenuService {
    public List<Menu> findAll();
    public String save(Menu dish);
}
