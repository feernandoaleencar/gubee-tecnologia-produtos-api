package com.fernandoalencar.gubeetecnologiaprodutos;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fernandoalencar.gubeetecnologiaprodutos.api.controller.ProdutoController;
import com.fernandoalencar.gubeetecnologiaprodutos.api.dto.ProdutoDTO;

@SpringBootTest
class GubeeTecnologiaProdutosApplicationTests {
	
	private ProdutoController produtoController;
	
	@Test
	@DisplayName("Retornar uma lista de produtos")
	void listar() {
		List<ProdutoDTO> lista = new ArrayList<ProdutoDTO>();
		produtoController = new ProdutoController();
		assertTrue(produtoController.listar().size() > 0);
	}
	

}
