package dev.octaviomarchi.backend.dtos;

import dev.octaviomarchi.backend.models.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProductDTO {

    private String codigo;
    private String descricao;

    public ProductDTO(Product product) {
        this.codigo = product.getCodProduto();
        this.descricao = product.getDesProduto();
    }
}
