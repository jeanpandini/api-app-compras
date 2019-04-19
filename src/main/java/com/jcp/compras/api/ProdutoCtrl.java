package com.jcp.compras.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@PostMapping
	public ResponseEntity<Produto> adicionar(@RequestBody final Produto produto) {
		return ResponseEntity.created(null).body(produtoService.adicionar(produto));
	}

	@PutMapping("{id}")
	public ResponseEntity<Produto> atualizar(@PathVariable final Long id, @RequestBody final Produto produto) {
		return ResponseEntity.accepted().body(produtoService.atualizar(id, produto));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Object> remover(@PathVariable final Long id) {
		produtoService.remove(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("{id}")
	public ResponseEntity<Produto> buscaPorId(@PathVariable final Long id) {
		return ResponseEntity.ok(produtoService.buscar(id));
	}

	@GetMapping
	public ResponseEntity<List<Produto>> buscaTodosProduto() {
		return ResponseEntity.ok(produtoService.buscaTodosProdutos());
	}
}
