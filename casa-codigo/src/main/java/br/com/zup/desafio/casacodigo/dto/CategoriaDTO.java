package br.com.zup.desafio.casacodigo.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.zup.desafio.casacodigo.config.validacao.UniqueValue;
import br.com.zup.desafio.casacodigo.model.Categoria;

public class CategoriaDTO {

	@NotNull
	@NotEmpty
	@Length(min = 2)
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
	private String nome;

	public CategoriaDTO() {

	}

	public CategoriaDTO(Categoria categoria) {
		this.nome = categoria.getNome();
	}
	
	public String getNome() {
		return nome;
	}	

}
