package dev.octaviomarchi.backend.repository;

import dev.octaviomarchi.backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
