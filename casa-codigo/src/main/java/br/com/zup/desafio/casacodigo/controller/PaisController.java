package br.com.zup.desafio.casacodigo.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.desafio.casacodigo.dto.PaisDTO;
import br.com.zup.desafio.casacodigo.dto.PaisFormDTO;
import br.com.zup.desafio.casacodigo.model.Pais;
import br.com.zup.desafio.casacodigo.repository.PaisRepository;

@RestController
@RequestMapping("/pais")
public class PaisController {

	private final PaisRepository paisRepository;

	public PaisController(PaisRepository paisRepository) {
		super();
		this.paisRepository = paisRepository;
	}

	@PostMapping
	public ResponseEntity<PaisFormDTO> inserir(@RequestBody @Valid PaisDTO PaisDto) {
		Pais pais = PaisDto.converter();
		paisRepository.save(pais);
		
		return ResponseEntity.ok().body(new PaisFormDTO(pais));
	}
}
