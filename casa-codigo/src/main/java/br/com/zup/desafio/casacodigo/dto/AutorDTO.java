package br.com.zup.desafio.casacodigo.dto;

import br.com.zup.desafio.casacodigo.model.Autor;

public class AutorDTO {

private Long id;
	
	private String nome;
	private String email;
	private String descricao;
	
	public AutorDTO() {
		
	}
	
	public AutorDTO(Autor autor) {
		this.id = autor.getId();
		this.email = autor.getEmail();
		this.descricao = autor.getDescricao();
	}

	public Long getId() {
		return id;
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

	public Autor converter() {
		return new Autor(nome, email, descricao);
	}
}
