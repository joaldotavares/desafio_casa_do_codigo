package br.com.zup.desafio.casacodigo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.desafio.casacodigo.dto.CategoriaDTO;
import br.com.zup.desafio.casacodigo.dto.CategoriaFormDTO;
import br.com.zup.desafio.casacodigo.model.Categoria;
import br.com.zup.desafio.casacodigo.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	private final CategoriaRepository categoriaRepository;

	public CategoriaController(CategoriaRepository categoriaRepository) {
		super();
		this.categoriaRepository = categoriaRepository;
	}

	@GetMapping
	public ResponseEntity<List<Categoria>> listar() {
		List<Categoria> lista = categoriaRepository.findAll();
		return ResponseEntity.ok().body(lista);
	}

	@PostMapping
	public ResponseEntity<CategoriaFormDTO> inserir(@RequestBody @Valid CategoriaDTO categoriaDto) {
		Categoria categoria = categoriaDto.converter();
		categoria = categoriaRepository.save(categoria);
		return ResponseEntity.ok(new CategoriaFormDTO(categoria));
	}

}
