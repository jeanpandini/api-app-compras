package com.jcp.compras.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jcp.compras.model.Produto;

@Service
public class ProdutoService {
	private static Map<Long, Produto> listAllProdutos = new HashMap<Long, Produto>() {
		private static final long serialVersionUID = 1L;
		{
			put(1l, new Produto(1l, "Banana"));
		}
	};
	// <Produto>(Arrays.asList(new Produto(1l, "Banana")));

	public List<Produto> buscaTodosProdutos() {
		return listAllProdutos.values().stream().collect(Collectors.toList());
	}

	public Produto adicionar(final Produto produto) {
		produto.setId(listAllProdutos.size() + 1l);
		listAllProdutos.put(produto.getId(), produto);
		return buscar(produto.getId());
	}

	public Produto atualizar(final Long id, final Produto produto) {
		buscar(id);
		return listAllProdutos.put(produto.getId(), produto);
	}

	public Produto buscar(final Long id) {
		return listAllProdutos.values().stream().filter(p -> p.getId().equals(id)).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Produto não encontrado."));
	}

	public void remove(final Long id) {
		buscar(id);
		listAllProdutos.remove(id);
	}
}
