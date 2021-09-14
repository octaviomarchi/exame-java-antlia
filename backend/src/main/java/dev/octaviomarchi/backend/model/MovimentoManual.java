package dev.octaviomarchi.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "MOVIMENTO_MANUAL")
@Entity
@IdClass(MovimentoManualId.class)
public class MovimentoManual {

    @Id
    @Column(name = "DAT_MES", columnDefinition = "numeric(2,0)")
    private Long datMes;

    @Id
    @Column(name = "DAT_ANO", columnDefinition = "numeric(4,0)")
    private Long datAno;

    @Id
    @Column(name = "NUM_LANCAMENTO", columnDefinition = "numeric(18,0)")
    private Long numLancamento;

    @Column(name = "DES_DESCRICAO", length = 50)
    private String desDescricao;

    @Column(name = "DAT_MOVIMENTO", columnDefinition = "smalldatetime")
    @CreationTimestamp()
    private LocalDateTime datMovimento;

    @Column(name = "COD_USUARIO", length = 15)
    private String codUsuario = "TESTE";

    @Column(name = "VAL_VALOR", columnDefinition = "numeric(18,2)")
    private Double valValor;

    @ManyToOne()
    @JoinColumn(name = "COD_COSIF")
    private ProdutoCosif produtoCosif;

    public MovimentoManual(Long datMes, Long datAno, String desDescricao, Double valValor, ProdutoCosif produtoCosif) {
        this.datMes = datMes;
        this.datAno = datAno;
        this.desDescricao = desDescricao;
        this.valValor = valValor;
        this.produtoCosif = produtoCosif;
    }
}
