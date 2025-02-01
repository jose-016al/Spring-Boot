package com.jose.spring_secure_api.service;

import com.jose.spring_secure_api.dto.ProductRequestDTO;
import com.jose.spring_secure_api.dto.ProductResponseDTO;

import java.util.List;

public interface IProductService {
    public List<ProductResponseDTO> findAll();
    public void save(ProductRequestDTO request);
}
