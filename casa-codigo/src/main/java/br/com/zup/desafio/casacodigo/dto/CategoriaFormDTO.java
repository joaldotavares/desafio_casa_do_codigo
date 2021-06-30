package br.com.zup.desafio.casacodigo.dto;

import br.com.zup.desafio.casacodigo.model.Categoria;

public class CategoriaFormDTO {

	private Long id;
	private String nome;

	public CategoriaFormDTO(Categoria categoria) {
		this.id = categoria.getId();
		this.nome = categoria.getNome();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

}
