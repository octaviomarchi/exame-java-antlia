package dev.octaviomarchi.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "PRODUTO")
@Entity
public class Produto {

    @Id
    @Column(name = "COD_PRODUTO", nullable = false, length = 4, columnDefinition = "char(4)")
    private String codProduto;

    @Column(name = "DES_PRODUTO", length = 30, columnDefinition = "varchar(30)")
    @Nullable
    private String desProduto;

    @Column(name = "STA_STATUS", length = 1, columnDefinition = "char(1)")
    @Nullable
    private String staStatus;

    @OneToMany(
            mappedBy = "produto",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ProdutoCosif> produtoCosifList = new ArrayList<>();

    public Produto(String codProduto) {
        this.codProduto = codProduto;
    }

    public Produto(String codProduto, @Nullable String desProduto, @Nullable String staStatus) {
        this.codProduto = codProduto;
        this.desProduto = desProduto;
        this.staStatus = staStatus;
    }
}
