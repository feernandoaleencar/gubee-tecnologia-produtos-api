package com.fernandoalencar.gubeetecnologiaprodutos.api.dto;

public class ProdutoDTO {
	
	private Long id;
	
	private String nomeProduto;
	
	private String descricao;
	
	private MercadoAlvoDTO mercadoAlvoDTO;
	
	private TecnologiaDTO tecnologiaDTO;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public MercadoAlvoDTO getMercadoAlvoDTO() {
		return mercadoAlvoDTO;
	}

	public void setMercadoAlvoDTO(MercadoAlvoDTO mercadoAlvoDTO) {
		this.mercadoAlvoDTO = mercadoAlvoDTO;
	}

	public TecnologiaDTO getTecnologiaDTO() {
		return tecnologiaDTO;
	}

	public void setTecnologiaDTO(TecnologiaDTO tecnologiaDTO) {
		this.tecnologiaDTO = tecnologiaDTO;
	}
	
}
