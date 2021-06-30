package br.com.zup.desafio.casacodigo.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.desafio.casacodigo.dto.EstadoDTO;
import br.com.zup.desafio.casacodigo.dto.EstadoFormDTO;
import br.com.zup.desafio.casacodigo.model.Estado;
import br.com.zup.desafio.casacodigo.repository.EstadoRepository;
import br.com.zup.desafio.casacodigo.repository.PaisRepository;

@RestController
@RequestMapping("/estado")
public class EstadoController {
	
	private final EstadoRepository estadoRepository;
	
	private final PaisRepository paisRepository;
	
	public EstadoController(EstadoRepository estadoRepository, PaisRepository paisRepository) {
		super();
		this.estadoRepository = estadoRepository;
		this.paisRepository = paisRepository;
	}

	@PostMapping
	public ResponseEntity<EstadoFormDTO> inserir(@RequestBody @Valid EstadoDTO estadoDto){
		Estado estado = estadoDto.converter(paisRepository);
		estadoRepository.save(estado);
		
		return ResponseEntity.ok().body(new EstadoFormDTO(estado));
		
	}
}
