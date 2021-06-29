package br.com.zup.desafio.casacodigo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.zup.desafio.casacodigo.model.Autor;

public class AutorDTO {

	private Long id;

	@NotEmpty
	@NotNull
	private String nome;
	
	@Email
	@NotEmpty
	@NotNull
	private String email;
	
	@NotNull
	@Length(max = 400)
	@NotEmpty
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
