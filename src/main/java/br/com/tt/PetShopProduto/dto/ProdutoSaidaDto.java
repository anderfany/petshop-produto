package br.com.tt.PetShopProduto.dto;

import br.com.tt.PetShopProduto.model.Produto;

import java.math.BigDecimal;

public class ProdutoSaidaDto {

    //Atributo
    private Long id;
    private String descricao;
    private BigDecimal valor;

    //Constrtor
    private ProdutoSaidaDto(Produto produto) {
        this.id = produto.getId();
        this.descricao = produto.getDescricao();
        this.valor = produto.getValor();
    }

    //Metodos
    public static ProdutoSaidaDto build(Produto produto) {
        return new ProdutoSaidaDto(produto);
    }

    //Getters
    public Long getId() { return id; }

    public String getDescricao() { return descricao; }

    public BigDecimal getValor() { return valor; }

}
