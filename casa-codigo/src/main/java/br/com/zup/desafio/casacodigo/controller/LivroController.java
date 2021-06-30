package br.com.zup.desafio.casacodigo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.desafio.casacodigo.dto.DetalhesLivroDTO;
import br.com.zup.desafio.casacodigo.dto.LivroDTO;
import br.com.zup.desafio.casacodigo.dto.LivroFormDTO;
import br.com.zup.desafio.casacodigo.model.Livro;
import br.com.zup.desafio.casacodigo.repository.AutorRepository;
import br.com.zup.desafio.casacodigo.repository.CategoriaRepository;
import br.com.zup.desafio.casacodigo.repository.LivroRepository;

@RestController
@RequestMapping(value = "/livro")
public class LivroController {

	private final LivroRepository livroRepository;

	private final CategoriaRepository categoriaRepository;

	private final AutorRepository autorRepository;

	public LivroController(LivroRepository livroRepository, CategoriaRepository categoriaRepository,
			AutorRepository autorRepository) {
		super();
		this.livroRepository = livroRepository;
		this.categoriaRepository = categoriaRepository;
		this.autorRepository = autorRepository;
	}

	@GetMapping
	public ResponseEntity<List<Livro>> listar() {
		List<Livro> lista = livroRepository.findAll();
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping("/{id}")
	public ResponseEntity<DetalhesLivroDTO> detalhar(@PathVariable Long id){
		Optional<Livro> livro = livroRepository.findById(id);
		if(livro.isPresent()) {
			return ResponseEntity.ok(new DetalhesLivroDTO(livro.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<LivroFormDTO> inserir(@RequestBody @Valid LivroDTO livroDto) {
		Livro livro = livroDto.converter(categoriaRepository, autorRepository);
		livroRepository.save(livro);
		return ResponseEntity.ok().body(new LivroFormDTO(livro));
	}
	
	

}
