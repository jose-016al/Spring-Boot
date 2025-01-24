package com.example.gestorPedidos.dto;

import com.example.gestorPedidos.model.Menu;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
public class OrderDTO {
    private Long id;
    private double total;
}
