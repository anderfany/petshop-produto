package br.com.tt.PetShopProduto.dto;

import java.math.BigDecimal;

public class ProdutoEntradaDto {

    private String descricao;
    private BigDecimal valor;

    public ProdutoEntradaDto(String descricao, BigDecimal valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
