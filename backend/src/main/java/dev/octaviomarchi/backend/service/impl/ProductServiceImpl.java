package dev.octaviomarchi.backend.service.impl;

import dev.octaviomarchi.backend.dtos.ProductDTO;
import dev.octaviomarchi.backend.model.Product;
import dev.octaviomarchi.backend.repository.ProductRepository;
import dev.octaviomarchi.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<ProductDTO> getProductsForDropdown() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOS = products.stream().map(ProductDTO::new).collect(Collectors.toList());
        return productDTOS;
    }
}
