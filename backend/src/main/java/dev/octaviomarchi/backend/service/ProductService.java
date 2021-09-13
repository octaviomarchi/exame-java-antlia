package dev.octaviomarchi.backend.service;

import dev.octaviomarchi.backend.dtos.ProductDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getProductsForDropdown();
}
