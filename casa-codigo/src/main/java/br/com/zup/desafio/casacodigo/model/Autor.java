package br.com.zup.desafio.casacodigo.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	@Email
	private String email;
	
	@Column(nullable = false, length = 400)
	private String descricao;
	
	@Column(nullable = false)
	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
	private LocalDateTime instante;
	
	public Autor(String nome, @Email String email, String descricao, LocalDateTime instante) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
		this.instante = instante;
	}
	
	public Autor() {
		super();
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
