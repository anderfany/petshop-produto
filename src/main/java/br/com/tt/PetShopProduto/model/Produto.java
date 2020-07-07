package br.com.tt.PetShopProduto.model;


import br.com.tt.PetShopProduto.dto.ProdutoEntradaDto;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_produto")
public class Produto {

    //Atributo
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Geração automática pelo BD
    @Column(name = "ID")
    private long id;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    //Construtor default para o Hibernate
    Produto() {
    }

    //Construtor
    public Produto(String descricao, BigDecimal valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    //Getters
    public long getId() { return id; }

    public String getDescricao() { return descricao; }

    public BigDecimal getValor() { return valor; }


    //Metodo
    public void criarProduto(ProdutoEntradaDto produto) {
        this.descricao = produto.getDescricao();
        this.valor = produto.getValor();
    }
}
