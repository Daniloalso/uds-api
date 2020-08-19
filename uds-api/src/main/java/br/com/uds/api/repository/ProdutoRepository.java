package br.com.uds.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.uds.api.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Integer>{

}
