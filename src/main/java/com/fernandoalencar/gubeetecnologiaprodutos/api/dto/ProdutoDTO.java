package com.fernandoalencar.gubeetecnologiaprodutos.api.dto;

import java.util.ArrayList;
import java.util.List;

import com.fernandoalencar.gubeetecnologiaprodutos.model.MercadoAlvo;
import com.fernandoalencar.gubeetecnologiaprodutos.model.Tecnologia;

public class ProdutoDTO {
	
	private String nome;
	
	private String descricao;
	
	private List<MercadoAlvo> mercadoAlvo;
	
	private List<Tecnologia> tecnologia;

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

		public List<String> getMercadoAlvo() {
			ArrayList<String> array = new ArrayList<String>();
	        mercadoAlvo.forEach(mercadoAlvo -> array.add(mercadoAlvo.getNome()));
	        return array;
		}

		public void setMercadoAlvo(List<MercadoAlvo> mercadoAlvo) {
			this.mercadoAlvo = mercadoAlvo;
		}

		public List<String> getTecnologia() {
			ArrayList<String> array = new ArrayList<String>();
	        tecnologia.forEach(tecnologia -> array.add(tecnologia.getNome()));
			return array;
		}

		public void setTecnologia(List<Tecnologia> tecnologia) {
			this.tecnologia = tecnologia;
		}
		
}
