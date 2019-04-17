package com.jcp.compras.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jcp.compras.model.Produto;
import com.jcp.compras.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoCtrl {

	private final ProdutoService produtoService;

	@Autowired
	public ProdutoCtrl(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	@GetMapping
	public List<Produto> buscaTodosProduto() {
		return produtoService.buscaTodosProdutos();
	}
}
