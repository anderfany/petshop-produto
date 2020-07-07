package br.com.tt.PetShopProduto.service;

import br.com.tt.PetShopProduto.dto.ProdutoEntradaDto;
import br.com.tt.PetShopProduto.dto.ProdutoSaidaDto;
import br.com.tt.PetShopProduto.model.Produto;
import br.com.tt.PetShopProduto.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    //Atributo
    private ProdutoRepository produtoRepository;

    //Construtor
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    //Metodos
    public Produto criar(ProdutoEntradaDto produto) {
        //Converte para entidade
        Produto novoProduto = produto.toEntity();
        //Salva novo produto no Datasource
        Produto produtoSalvo = produtoRepository.save(novoProduto);
        //Retorna produto salvo para o controller
        return produtoSalvo;
    }

    public List<ProdutoSaidaDto> listar() {
        return produtoRepository.findAll()
                //Inicia o stream
                .stream()
                //Invoca o build para SaidaDto
                .map(ProdutoSaidaDto::build)
                //Retorna uma lista
                .collect(Collectors.toList());
    }

    public void remover(Long id) {
        produtoRepository.findById(id)
                //Se existe remove
                .ifPresent( produto -> produtoRepository.delete(produto));
                //.ifPresentOrElse( produto -> produtoRepository.delete(produto);
                //() -> {throw new RuntimeException("Produto não existe");});
    }
}
