package br.com.tt.PetShopProduto.service;

import br.com.tt.PetShopProduto.dto.ProdutoEntradaDto;
import br.com.tt.PetShopProduto.model.Produto;
import br.com.tt.PetShopProduto.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ProdutoService {

    //Atributo
    private ProdutoRepository produtoRepository;

    //Construtor
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    //Metodo
    public Produto criar(ProdutoEntradaDto produto) {
        Produto novoProduto = new Produto(produto);
        return produtoRepository.save(novoProduto);
    }

    public void remover(Long id) {
        produtoRepository.findById(id)
                .ifPresent( produto -> produtoRepository.delete(produto));
                //.ifPresentOrElse( produto -> produtoRepository.delete(produto);
                //() -> {throw new RuntimeException("Produto não existe");});
    }
}
