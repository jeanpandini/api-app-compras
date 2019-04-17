package com.jcp.compras.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jcp.compras.model.Produto;

@Service
public class ProdutoService {
	private static List<Produto> listAllProdutos = new ArrayList<Produto>();

	public List<Produto> buscaTodosProdutos() {
		return ProdutoService.listAllProdutos;
	}

	public void adicionaProduto(final Produto produto) {
		listAllProdutos.add(produto);
	}
}
