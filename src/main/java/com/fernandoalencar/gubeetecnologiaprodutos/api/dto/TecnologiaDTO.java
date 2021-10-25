package com.fernandoalencar.gubeetecnologiaprodutos.api.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.fernandoalencar.gubeetecnologiaprodutos.model.Produto;

public class TecnologiaDTO {

	private Long id;
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
