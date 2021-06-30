package br.com.zup.desafio.casacodigo.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.zup.desafio.casacodigo.config.validacao.ResourceException;
import br.com.zup.desafio.casacodigo.config.validacao.UniqueValue;
import br.com.zup.desafio.casacodigo.model.Estado;
import br.com.zup.desafio.casacodigo.model.Pais;
import br.com.zup.desafio.casacodigo.repository.PaisRepository;

public class EstadoDTO {

	@NotEmpty
	@UniqueValue(domainClass = Estado.class, fieldName = "nome")
	private String nome;

	@NotNull
	private Long paisId;

	public EstadoDTO(@NotEmpty String nome, @NotNull Long paisId) {
		super();
		this.nome = nome;
		this.paisId = paisId;
	}

	public Estado converter(PaisRepository paisRepository) {
		Pais pais = paisRepository.findById(paisId)
				.orElseThrow(() -> new ResourceException("Id de estado não encontrado"));

		return new Estado(nome, pais);
	}

	public String getNome() {
		return nome;
	}

	public Long getPaisId() {
		return paisId;
	}

}
