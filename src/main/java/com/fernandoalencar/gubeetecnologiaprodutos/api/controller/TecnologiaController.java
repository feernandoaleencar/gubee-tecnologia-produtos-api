package com.fernandoalencar.gubeetecnologiaprodutos.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fernandoalencar.gubeetecnologiaprodutos.api.dto.ProdutoDTO;
import com.fernandoalencar.gubeetecnologiaprodutos.api.dto.TecnologiaDTO;
import com.fernandoalencar.gubeetecnologiaprodutos.model.Produto;
import com.fernandoalencar.gubeetecnologiaprodutos.model.Tecnologia;
import com.fernandoalencar.gubeetecnologiaprodutos.repository.TecnologiaRepository;

@RestController
@RequestMapping("/tecnologias")
public class TecnologiaController {
	
	@Autowired
	private TecnologiaRepository tecnologiaRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping
	public List<TecnologiaDTO> listar(){
		List<TecnologiaDTO> lista = toCollectionModel(tecnologiaRepository.findAll());

		return lista;
	}
	
	private TecnologiaDTO toModel(Tecnologia tecnologia) {
		return modelMapper.map(tecnologia, TecnologiaDTO.class);
	}

	private List<TecnologiaDTO> toCollectionModel(List<Tecnologia> tecnologias) {
		return tecnologias.stream().map(tecnologia -> toModel(tecnologia)).collect(Collectors.toList());
	}
}
