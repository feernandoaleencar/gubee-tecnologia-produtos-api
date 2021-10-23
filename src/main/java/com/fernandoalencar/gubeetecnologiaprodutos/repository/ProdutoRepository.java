package com.fernandoalencar.gubeetecnologiaprodutos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernandoalencar.gubeetecnologiaprodutos.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
