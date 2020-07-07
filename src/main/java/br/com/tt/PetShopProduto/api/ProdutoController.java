package br.com.tt.PetShopProduto.api;

import br.com.tt.PetShopProduto.dto.ProdutoEntradaDto;
import br.com.tt.PetShopProduto.dto.ProdutoSaidaDto;
import br.com.tt.PetShopProduto.model.Produto;
import br.com.tt.PetShopProduto.service.ProdutoService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    //Atributo
    private ProdutoService produtoService;

    //Construtor
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    //Metodo
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity criar(@RequestBody ProdutoEntradaDto produto) {
        Produto produtoCriado = produtoService.criar(produto);
        String location = String.format("/produtos/%d", produtoCriado.getId());

        return ResponseEntity
                .created(URI.create(location)).
                        build();

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProdutoSaidaDto> listar() {
        return produtoService.listar();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity remover(@PathVariable("id") Long id) {
        produtoService.remover(id);
        return ResponseEntity.noContent().build();
    }

}
