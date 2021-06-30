package br.com.zup.desafio.casacodigo.dto;

import javax.validation.constraints.NotBlank;

import br.com.zup.desafio.casacodigo.config.validacao.UniqueValue;
import br.com.zup.desafio.casacodigo.model.Pais;

public class PaisDTO {

	@NotBlank
	@UniqueValue(domainClass = Pais.class, fieldName = "nome")
	private String nome;

	public PaisDTO() {

	}

	public PaisDTO(String nome) {
		super();
		this.nome = nome;
	}

	public Pais converter() {
		return new Pais(nome);
	}

	public String getNome() {
		return nome;
	}

}
