package dev.octaviomarchi.backend.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PRODUTO")
@Entity
public class Product {

    @Id
    @Column(name = "COD_PRODUTO", nullable = false, length = 4, columnDefinition = "char(4)")
    private String codProduto;

    @Column(name = "DES_PRODUTO", length = 30, columnDefinition = "varchar(30)")
    @Nullable
    private String desProduto;

    @Column(name = "STA_STATUS", length = 1, columnDefinition = "char(1)")
    @Nullable
    private String staStatus;
}