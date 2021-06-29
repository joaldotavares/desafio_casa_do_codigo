package br.com.zup.desafio.casacodigo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.zup.desafio.casacodigo.config.validacao.UniqueValue;
import br.com.zup.desafio.casacodigo.model.Autor;

public class AutorDTO {

	@NotEmpty
	@NotNull
	private String nome;
	
	@Email
	@NotEmpty
	@NotNull
	@UniqueValue(domainClass = Autor.class, fieldName = "email")
	private String email;
	
	@NotNull
	@Length(max = 400)
	@NotEmpty
	private String descricao;

	public AutorDTO() {

	}

	public AutorDTO(Autor autor) {
		this.email = autor.getEmail();
		this.descricao = autor.getDescricao();
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
