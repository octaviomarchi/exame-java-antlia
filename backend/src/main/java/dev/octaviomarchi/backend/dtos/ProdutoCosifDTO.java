package dev.octaviomarchi.backend.dtos;

import dev.octaviomarchi.backend.model.ProdutoCosif;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProdutoCosifDTO {

    private String codigoCosif;

    private String classificacao;

    public ProdutoCosifDTO(ProdutoCosif produtoCosif) {
        this.codigoCosif = produtoCosif.getCodCosif();
        this.classificacao = produtoCosif.getCodClassificacao();
    }
}
