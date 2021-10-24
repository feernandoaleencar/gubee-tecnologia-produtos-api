package com.fernandoalencar.gubeetecnologiaprodutos.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fernandoalencar.gubeetecnologiaprodutos.api.dto.ProdutoDTO;
import com.fernandoalencar.gubeetecnologiaprodutos.api.dto.form.ProdutoFormDTO;
import com.fernandoalencar.gubeetecnologiaprodutos.model.MercadoAlvo;
import com.fernandoalencar.gubeetecnologiaprodutos.model.Produto;
import com.fernandoalencar.gubeetecnologiaprodutos.model.Tecnologia;
import com.fernandoalencar.gubeetecnologiaprodutos.repository.MercadoAlvoRepository;
import com.fernandoalencar.gubeetecnologiaprodutos.repository.ProdutoRepository;
import com.fernandoalencar.gubeetecnologiaprodutos.repository.TecnologiaRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private MercadoAlvoRepository mercadoAlvoRepository;

	@Autowired
	private TecnologiaRepository tecnologiaRepository;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping
	public ResponseEntity<?> listar() {

		Iterable<ProdutoDTO> lista = toCollectionModel(produtoRepository.findAll());

		return new ResponseEntity<ProdutoDTO>(HttpStatus.OK).ok(lista);
	}
	
	@PostMapping
	public ResponseEntity<ProdutoDTO> cadastrar(@RequestBody ProdutoFormDTO produtoFormDTO) {

		List<Long> mercadosAlvoIds = produtoFormDTO.getMercadoAlvo();
		List<MercadoAlvo> mercados = new ArrayList<MercadoAlvo>();
		
		for (Long mercadoId : mercadosAlvoIds) {
			Optional<MercadoAlvo> mercadoAlvoOp = mercadoAlvoRepository.findById(mercadoId);
			
			if (!mercadoAlvoOp.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			
			mercados.add(mercadoAlvoOp.get());
		}
		
		
		List<Long> tecnologiasIds = produtoFormDTO.getTecnologia();
		List<Tecnologia> tecnologias = new ArrayList<Tecnologia>();
		
		for (Long tecnologiaId : tecnologiasIds) {
			Optional<Tecnologia> tecnologiaOp = tecnologiaRepository.findById(tecnologiaId);
			
			if (!tecnologiaOp.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			
			tecnologias.add(tecnologiaOp.get());
		}
		
		Produto p = new Produto();
		
		p.setDescricao(produtoFormDTO.getDescricao());
		p.setNome(produtoFormDTO.getNome());
		p.setMercadoAlvo(mercados);
		p.setTecnologia(tecnologias);
		
		Produto salvo = produtoRepository.save(p);
		
		return new ResponseEntity(HttpStatus.CREATED).ok(toModel(salvo));
		
	}
	
	private ProdutoDTO toModel(Produto produto) {
		return modelMapper.map(produto, ProdutoDTO.class);
	}

	private List<ProdutoDTO> toCollectionModel(List<Produto> produtos) {
		return produtos.stream().map(produto -> toModel(produto)).collect(Collectors.toList());
	}
	
	
}