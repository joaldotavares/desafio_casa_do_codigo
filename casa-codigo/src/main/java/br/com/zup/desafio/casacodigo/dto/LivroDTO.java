package br.com.zup.desafio.casacodigo.dto;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zup.desafio.casacodigo.config.validacao.ResourceException;
import br.com.zup.desafio.casacodigo.config.validacao.UniqueValue;
import br.com.zup.desafio.casacodigo.model.Autor;
import br.com.zup.desafio.casacodigo.model.Categoria;
import br.com.zup.desafio.casacodigo.model.Livro;
import br.com.zup.desafio.casacodigo.repository.AutorRepository;
import br.com.zup.desafio.casacodigo.repository.CategoriaRepository;

public class LivroDTO {

	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo")
	private String titulo;

	@NotBlank
	private String resumo;

	private String sumario;

	@Min(20)
	private Double preco;

	@Min(100)
	private Integer paginas;

	@UniqueValue(domainClass = Livro.class, fieldName = "isbn")
	private String isbn;

	@JsonFormat(pattern = "dd-MM-yyyy", shape = Shape.STRING)
	private LocalDate publicacao;

	@NotNull
	private Long categoriaId;

	@NotNull
	private Long autorId;

	public LivroDTO() {

	}

	public LivroDTO(String titulo, String resumo, String sumario, Double preco, Integer paginas, String isbn,
			LocalDate publicacao, Long categoriaId, Long autorId) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.paginas = paginas;
		this.isbn = isbn;
		this.publicacao = publicacao;
		this.categoriaId = categoriaId;
		this.autorId = autorId;
	}

	public Livro converter(CategoriaRepository categoriaRepository, AutorRepository autorRepository) {

		Categoria categoria = categoriaRepository.findById(categoriaId)
				.orElseThrow(() -> new ResourceException("Id de categoria não existe"));
		Autor autor = autorRepository.findById(autorId)
				.orElseThrow(() -> new ResourceException("Id de autor não existe"));

		return new Livro(titulo, resumo, sumario, preco, paginas, isbn, publicacao, categoria, autor);
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
