package com.fernandoalencar.gubeetecnologiaprodutos.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fernandoalencar.gubeetecnologiaprodutos.model.Tecnologia;
import com.fernandoalencar.gubeetecnologiaprodutos.repository.TecnologiaRepository;

@RestController
@RequestMapping("/tecnologias")
public class TecnologiaController {
	
	@Autowired
	private TecnologiaRepository tecnologiaRepository;
	
	@GetMapping
	public List<Tecnologia> listar(){
		return tecnologiaRepository.findAll();
	}
}
