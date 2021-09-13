package dev.octaviomarchi.backend.dtos;

import dev.octaviomarchi.backend.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {

    private String codigo;
    private String descricao;

    public ProductDTO(Product product) {
        this.codigo = product.getCodProduto();
        this.descricao = product.getDesProduto();
    }
}
