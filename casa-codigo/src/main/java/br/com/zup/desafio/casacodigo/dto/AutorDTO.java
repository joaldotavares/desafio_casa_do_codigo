package br.com.zup.desafio.casacodigo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import br.com.zup.desafio.casacodigo.config.validacao.UniqueValue;
import br.com.zup.desafio.casacodigo.model.Autor;

public class AutorDTO {

	@NotBlank
	private String nome;

	@Email
	@NotBlank
	@UniqueValue(domainClass = Autor.class, fieldName = "email")
	private String email;

	@NotBlank
	private String descricao;

	public AutorDTO() {

	}

	public AutorDTO(@NotBlank String nome, @Email @NotBlank String email, @NotBlank String descricao) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
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
