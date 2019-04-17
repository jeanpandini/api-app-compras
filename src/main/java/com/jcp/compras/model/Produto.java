package com.jcp.compras.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Produto implements Serializable {
	private Long id;
	private String nome;

	public Produto(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}
}
