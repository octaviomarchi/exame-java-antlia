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
    @Column(name = "DAT_MES")
    private Long datMes;

    @Id
    @Column(name = "DAT_ANO")
    private Long datAno;

    // retirado por conta da segunda forma normal
    // private Long numLancamento;

    @Column(name = "DES_DESCRICAO")
    private String desDescricao;

    @Column(name = "DAT_MOVIMENTO")
    @CreationTimestamp()
    private LocalDateTime datMovimento;

    @Column(name = "COD_USUARIO")
    private String codUsuario = "TESTE";

    @Column(name = "VAL_VALOR")
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
