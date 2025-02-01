package com.jose.spring_secure_api.service;

import com.jose.spring_secure_api.dto.ProductRequestDTO;
import com.jose.spring_secure_api.dto.ProductResponseDTO;
import com.jose.spring_secure_api.model.Product;
import com.jose.spring_secure_api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepository productRepository;

    @Override
    public List<ProductResponseDTO> findAll() {
        return productRepository.findAll().stream()
                .map(product -> ProductResponseDTO.builder()
                        .name(product.getName())
                        .price(product.getPrice())
                        .build()
                )
                .toList();
    }

    @Override
    public void save(ProductRequestDTO request) {
        productRepository.save(Product.builder()
                .name(request.getName())
                .price(request.getPrice())
                .build());
    }
}
