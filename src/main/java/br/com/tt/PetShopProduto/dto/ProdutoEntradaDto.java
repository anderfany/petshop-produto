package br.com.tt.PetShopProduto.dto;

import br.com.tt.PetShopProduto.model.Produto;

import java.math.BigDecimal;

public class ProdutoEntradaDto {

    //Atributos
    private String descricao;
    private BigDecimal valor;

    //Construtor
    public ProdutoEntradaDto(String descricao, BigDecimal valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    //Getters
    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    //Metodo toEntity
    public Produto toEntity() {
        return new Produto(descricao, valor);
    }

}