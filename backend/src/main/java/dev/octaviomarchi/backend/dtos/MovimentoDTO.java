package dev.octaviomarchi.backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class MovimentoDTO {

    private String mes;
    private String ano;
    private String produto;
    private String cosif;
    private Double valor;
    private String descricao;

    public MovimentoDTO(String mes, String ano, String produto, String cosif, Double valor, String descricao) {
        this.mes = mes;
        this.ano = ano;
        this.produto = produto;
        this.cosif = cosif;
        this.valor = valor;
        this.descricao = descricao;
    }

    public MovimentoDTO() {
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getCosif() {
        return cosif;
    }

    public void setCosif(String cosif) {
        this.cosif = cosif;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
