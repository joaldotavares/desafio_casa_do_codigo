package br.com.zup.desafio.casacodigo.dto;

import java.time.LocalDate;

import br.com.zup.desafio.casacodigo.model.Livro;

public class LivroFormDTO {

	private Long id;
	private String titulo;
	private String resumo;
	private String sumario;
	private Double preco;
	private Integer paginas;
	private String isbn;
	private LocalDate publicacao;
	private Long categoriaId;
	private Long autorId;

	public LivroFormDTO(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.paginas = livro.getPaginas();
		this.isbn = livro.getIsbn();
		this.publicacao = livro.getPublicacao();
		this.categoriaId = livro.getCategoria().getId();
		this.autorId = livro.getAutor().getId();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public Double getPreco() {
		return preco;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getPublicacao() {
		return publicacao;
	}

	public Long getCategoriaId() {
		return categoriaId;
	}

	public Long getAutorId() {
		return autorId;
	}
}
