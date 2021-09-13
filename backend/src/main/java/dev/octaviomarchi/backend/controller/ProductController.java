package dev.octaviomarchi.backend.controller;

import dev.octaviomarchi.backend.dtos.ProductDTO;
import dev.octaviomarchi.backend.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductServiceImpl productServiceImpl;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDTO> getProducts() {
        List<ProductDTO> products = productServiceImpl.getProductsForDropdown();
        return products;
    }
}
