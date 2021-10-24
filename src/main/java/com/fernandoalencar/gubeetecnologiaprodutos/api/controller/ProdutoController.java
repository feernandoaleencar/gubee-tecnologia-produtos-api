package com.fernandoalencar.gubeetecnologiaprodutos.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fernandoalencar.gubeetecnologiaprodutos.model.Produto;
import com.fernandoalencar.gubeetecnologiaprodutos.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
		
		@Autowired
		private ProdutoRepository produtoRepository;
		
		@GetMapping
		public ResponseEntity<?> listar(){
			
			Iterable<Produto> lista = produtoRepository.findAll();
			
			return new ResponseEntity<Produto>(HttpStatus.OK).ok(lista);
		}
		
}