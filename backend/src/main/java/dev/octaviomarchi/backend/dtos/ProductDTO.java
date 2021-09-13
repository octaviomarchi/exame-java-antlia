package dev.octaviomarchi.backend.dtos;

import dev.octaviomarchi.backend.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {

    private String codigo;
    private String descricao;

    public ProductDTO(Produto produto) {
        this.codigo = produto.getCodProduto();
        this.descricao = produto.getDesProduto();
    }
}
