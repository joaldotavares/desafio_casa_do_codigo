package br.com.zup.desafio.casacodigo.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.desafio.casacodigo.dto.ClienteDTO;
import br.com.zup.desafio.casacodigo.dto.ClienteFormDTO;
import br.com.zup.desafio.casacodigo.model.Cliente;
import br.com.zup.desafio.casacodigo.repository.ClienteRepository;
import br.com.zup.desafio.casacodigo.repository.EstadoRepository;
import br.com.zup.desafio.casacodigo.repository.PaisRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	private final ClienteRepository clienteRepository;
	private final PaisRepository paisRepository;
	private final EstadoRepository estadoRepository;
	
	public ClienteController(ClienteRepository clienteRepository, PaisRepository paisRepository,
			EstadoRepository estadoRepository) {
		super();
		this.clienteRepository = clienteRepository;
		this.paisRepository = paisRepository;
		this.estadoRepository = estadoRepository;
	}
	
	@PostMapping
	public ResponseEntity<ClienteFormDTO> inserir(@RequestBody @Valid ClienteDTO clienteDto) {
		Cliente cliente = clienteDto.converter(paisRepository, estadoRepository);
		clienteRepository.save(cliente);
		
		return ResponseEntity.ok().body(new ClienteFormDTO(cliente));
		
	}
	
}
