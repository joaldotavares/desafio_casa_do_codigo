package br.com.zup.desafio.casacodigo.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.zup.desafio.casacodigo.model.Categoria;

public class CategoriaDTO {

	@NotNull
	@NotEmpty
	@Length(min = 2)
	private String nome;

	public CategoriaDTO() {

	}

	public CategoriaDTO(Categoria categoria) {
		this.nome = categoria.getNome();
	}

	public Categoria converter() {
		return new Categoria(nome);
	}

	public String getNome() {
		return nome;
	}	

}
