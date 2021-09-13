package dev.octaviomarchi.backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class MovimentoRespostaDTO {
    private Long mes;
    private Long ano;
    private String codigoProduto;
    private String descricaoProduto;
    private Long lancamento;
    private String descricao;
    private Double valor;

    public MovimentoRespostaDTO(Long mes, Long ano, String codigoProduto, String descricaoProduto, Long lancamento, String descricao, Double valor) {
        this.mes = mes;
        this.ano = ano;
        this.codigoProduto = codigoProduto;
        this.descricaoProduto = descricaoProduto;
        this.lancamento = lancamento;
        this.descricao = descricao;
        this.valor = valor;
    }

    public MovimentoRespostaDTO() {
    }

    public Long getMes() {
        return mes;
    }

    public void setMes(Long mes) {
        this.mes = mes;
    }

    public Long getAno() {
        return ano;
    }

    public void setAno(Long ano) {
        this.ano = ano;
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public Long getLancamento() {
        return lancamento;
    }

    public void setLancamento(Long lancamento) {
        this.lancamento = lancamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
