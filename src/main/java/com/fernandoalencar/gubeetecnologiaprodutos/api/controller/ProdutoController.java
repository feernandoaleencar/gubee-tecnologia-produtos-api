package com.fernandoalencar.gubeetecnologiaprodutos.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fernandoalencar.gubeetecnologiaprodutos.api.dto.ProdutoDTO;
import com.fernandoalencar.gubeetecnologiaprodutos.model.Produto;
import com.fernandoalencar.gubeetecnologiaprodutos.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
		
		@Autowired
		private ProdutoRepository produtoRepository;
		
		@Autowired
		private ModelMapper modelMapper;
		
		@GetMapping
		public List<ProdutoDTO> listar(){
			return toCollectionModel(produtoRepository.findAll());
		}
		
		private List<ProdutoDTO> toCollectionModel(List<Produto> produtos) {
			return produtos.stream().map(produto -> toModel(produto)).collect(Collectors.toList());
		}
		
		private ProdutoDTO toModel(Produto produto) {
			return modelMapper.map(produto, ProdutoDTO.class);
		}
	
}
