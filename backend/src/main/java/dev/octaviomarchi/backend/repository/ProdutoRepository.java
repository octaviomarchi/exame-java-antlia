package dev.octaviomarchi.backend.repository;

import dev.octaviomarchi.backend.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, String> {
}
