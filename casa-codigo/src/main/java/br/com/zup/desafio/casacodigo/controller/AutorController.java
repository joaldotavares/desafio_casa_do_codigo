package br.com.zup.desafio.casacodigo.controller;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public List<Autor> listar() {
		Autor autor = new Autor("Paulo Coelho", "paulo@email.com", "Escrito famoso por suas obras", LocalDateTime.now());
		return Arrays.asList(autor, autor, autor);
	}
}
