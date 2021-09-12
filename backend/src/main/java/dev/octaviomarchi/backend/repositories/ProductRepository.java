package dev.octaviomarchi.backend.repositories;

import dev.octaviomarchi.backend.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
