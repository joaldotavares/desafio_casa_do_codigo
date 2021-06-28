package br.com.zup.desafio.casacodigo.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	@NotEmpty
	private String nome;
	
	@Column(nullable = false, unique = true)
	@Email
	@NotEmpty
	private String email;
	
	@Column(nullable = false, length = 400)
	@NotEmpty
	private String descricao;
	
	@Column(nullable = false)
	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
	private LocalDateTime instante = LocalDateTime.now();
		
	public Autor() {
		super();
	}
		
	public Autor(String nome, @Email String email, String descricao) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
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
	public LocalDateTime getInstante() {
		return instante;
	}
	
}
