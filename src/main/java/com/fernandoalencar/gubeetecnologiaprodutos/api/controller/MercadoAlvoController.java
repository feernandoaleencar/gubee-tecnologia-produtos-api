package com.fernandoalencar.gubeetecnologiaprodutos.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fernandoalencar.gubeetecnologiaprodutos.api.dto.MercadoAlvoDTO;
import com.fernandoalencar.gubeetecnologiaprodutos.model.MercadoAlvo;
import com.fernandoalencar.gubeetecnologiaprodutos.repository.MercadoAlvoRepository;

@RestController
@RequestMapping("/mercadosAlvo")
public class MercadoAlvoController {
	
	@Autowired
	private MercadoAlvoRepository mercadoAlvoRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping
	public List<MercadoAlvoDTO> listar(){
		List<MercadoAlvoDTO> lista = toCollectionModel(mercadoAlvoRepository.findAll());

		return lista;
	}
	
	private MercadoAlvoDTO toModel(MercadoAlvo mercadoAlvo) {
		return modelMapper.map(mercadoAlvo, MercadoAlvoDTO.class);
	}

	private List<MercadoAlvoDTO> toCollectionModel(List<MercadoAlvo> mercadosAlvo) {
		return mercadosAlvo.stream().map(mercadoAlvo -> toModel(mercadoAlvo)).collect(Collectors.toList());
	}
}
