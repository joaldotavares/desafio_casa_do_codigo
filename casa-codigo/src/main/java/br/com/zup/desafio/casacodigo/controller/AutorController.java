package br.com.zup.desafio.casacodigo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.desafio.casacodigo.dto.AutorDTO;
import br.com.zup.desafio.casacodigo.dto.AutorFormDTO;
import br.com.zup.desafio.casacodigo.model.Autor;
import br.com.zup.desafio.casacodigo.repository.AutorRepository;

@RestController
@RequestMapping(value = "/autor")
public class AutorController {

	private final AutorRepository autorRepository;

	public AutorController(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}

	@GetMapping
	public ResponseEntity<List<Autor>> listar() {
		List<Autor> lista = autorRepository.findAll();
		return ResponseEntity.ok().body(lista);
	}

	@PostMapping
	public ResponseEntity<AutorFormDTO> inserir(@RequestBody @Valid AutorDTO autorDto) {
		Autor autor = autorDto.converter();
		autorRepository.save(autor);
		return ResponseEntity.ok(new AutorFormDTO(autor));
	}
}
