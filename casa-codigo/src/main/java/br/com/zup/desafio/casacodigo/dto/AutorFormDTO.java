package br.com.zup.desafio.casacodigo.dto;

import java.time.LocalDateTime;

import br.com.zup.desafio.casacodigo.model.Autor;

public class AutorFormDTO {
	
	private String nome;
	private String email;
	private String descricao;
	private LocalDateTime instante;

	public AutorFormDTO(Autor autor) {
		this.nome = autor.getNome();
		this.email = autor.getEmail();
		this.descricao = autor.getDescricao();
		this.instante = autor.getInstante();
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDateTime getInstante() {
		return instante;
	}

}
