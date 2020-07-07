package br.com.tt.PetShopProduto.repository;

import br.com.tt.PetShopProduto.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends
//        CrudRepository<Produto, Long> {
        JpaRepository<Produto, Long> {
//        PagingAndSortingRepository<Produto, Long> {
}
