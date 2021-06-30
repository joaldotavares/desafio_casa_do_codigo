package br.com.zup.desafio.casacodigo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String titulo;

	@NotBlank
	@Column(length = 500)
	private String resumo;

	@Column(columnDefinition = "TEXT")
	private String sumario;

	@NotNull
	@Min(20)
	private Double preco;

	@NotNull
	@Min(100)
	private Integer paginas;

	@NotBlank
	private String isbn;

	@Future
	private LocalDate publicacao;

	@NotNull
	@Valid
	@ManyToOne
	private Categoria categoria;

	@NotNull
	@Valid
	@ManyToOne
	private Autor autor;

	public Livro() {
		super();
	}

	public Livro(@NotBlank String titulo, @NotBlank String resumo, String sumario, @NotNull @Min(20) Double preco,
			@NotNull @Min(100) Integer paginas, @NotBlank String isbn, @Future LocalDate publicacao,
			@NotNull @Valid Categoria categoria, @NotNull @Valid Autor autor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.paginas = paginas;
		this.isbn = isbn;
		this.publicacao = publicacao;
		this.categoria = categoria;
		this.autor = autor;
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

	public Categoria getCategoria() {
		return categoria;
	}

	public Autor getAutor() {
		return autor;
	}

	public LocalDate getPublicacao() {
		return publicacao;
	}

}
