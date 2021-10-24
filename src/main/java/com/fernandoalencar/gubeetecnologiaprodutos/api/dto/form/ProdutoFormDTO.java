package com.fernandoalencar.gubeetecnologiaprodutos.api.dto.form;

import java.util.List;

public class ProdutoFormDTO {
	
	private String nome;
	
	private String descricao;
	
	private List<Long> mercadoAlvo;
	
	private List<Long> tecnologia;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Long> getMercadoAlvo() {
		return mercadoAlvo;
	}

	public void setMercadoAlvo(List<Long> mercadoAlvo) {
		this.mercadoAlvo = mercadoAlvo;
	}

	public List<Long> getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(List<Long> tecnologia) {
		this.tecnologia = tecnologia;
	}

}
