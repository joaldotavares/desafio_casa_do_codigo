package br.com.zup.desafio.casacodigo.dto;

import br.com.zup.desafio.casacodigo.model.Estado;

public class EstadoFormDTO {

	private Long id;
	private String nome;
	private Long paisId;

	public EstadoFormDTO(Estado estado) {
		this.id = estado.getId();
		this.nome = estado.getNome();
		this.paisId = estado.getPais().getId();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Long getPaisId() {
		return paisId;
	}

}
