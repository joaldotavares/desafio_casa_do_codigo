package br.com.zup.desafio.casacodigo.dto;

import br.com.zup.desafio.casacodigo.model.Pais;

public class PaisFormDTO {

	private Long id;
	private String nome;

	public PaisFormDTO(Pais pais) {
		this.id = pais.getId();
		this.nome = pais.getNome();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

}
