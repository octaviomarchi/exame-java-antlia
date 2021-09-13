package dev.octaviomarchi.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@Table(name = "PRODUTO_COSIF")
@Entity
public class ProdutoCosif {

    @Id
    @Column(name = "COD_COSIF")
    private String codCosif;

    @Column(name = "COD_CLASSIFICACAO")
    private String codClassificacao;

    @Column(name = "STA_STATUS")
    private String staStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_PRODUTO", nullable = false)
    private Produto produto;

    @OneToMany(mappedBy = "produtoCosif")
    private List<MovimentoManual> movimentoManual = new ArrayList<MovimentoManual>();

    public ProdutoCosif(String codCosif) {
        this.codCosif = codCosif;
    }

    public ProdutoCosif() {
    }

    public ProdutoCosif(String codCosif, String codClassificacao, String staStatus) {
        this.codCosif = codCosif;
        this.codClassificacao = codClassificacao;
        this.staStatus = staStatus;
    }

    public ProdutoCosif(String codCosif, String codClassificacao, String staStatus, Produto produto) {
        this.codCosif = codCosif;
        this.codClassificacao = codClassificacao;
        this.staStatus = staStatus;
        this.produto = produto;
    }
}