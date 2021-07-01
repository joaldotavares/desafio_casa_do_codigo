package br.com.zup.desafio.casacodigo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.desafio.casacodigo.config.validacao.ResourceException;
import br.com.zup.desafio.casacodigo.config.validacao.UniqueValue;
import br.com.zup.desafio.casacodigo.model.Cliente;
import br.com.zup.desafio.casacodigo.model.Estado;
import br.com.zup.desafio.casacodigo.model.Pais;
import br.com.zup.desafio.casacodigo.repository.EstadoRepository;
import br.com.zup.desafio.casacodigo.repository.PaisRepository;

public class ClienteDTO {

	@NotBlank
	@Email
	@UniqueValue(domainClass = Cliente.class, fieldName = "email")
	private String email;

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@NotBlank
	@UniqueValue(domainClass = Cliente.class, fieldName = "cpfOuCnpj")
	private String cpfOuCnpj;

	@NotBlank
	private String endereco;

	@NotBlank
	private String complemento;

	@NotBlank
	private String cidade;

	@NotNull
	private Long paisId;

	private Long estadoId;

	@NotBlank
	private String telefone;
	@NotBlank
	private String cep;

	public ClienteDTO() {
		super();
	}

	

	public ClienteDTO(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String cpfOuCnpj, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotNull Long paisId, Long estadoId, @NotBlank String telefone,
			@NotBlank String cep) {
		super();
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpfOuCnpj = cpfOuCnpj;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.paisId = paisId;
		this.estadoId = estadoId;
		this.telefone = telefone;
		this.cep = cep;
	}

	public Cliente converter(PaisRepository paisRepository, EstadoRepository estadoRepository) {

		Pais pais = paisRepository.findById(paisId)
				.orElseThrow(() -> new ResourceException("Id de país não encontrado"));
		Estado estado = null;
		if (estadoId != null) {
			estado = estadoRepository.findById(estadoId).orElseThrow(() -> new ResourceException("Id de estado não encontrado"));
		}
		return new Cliente(email, nome, sobrenome, cpfOuCnpj, endereco, complemento, cidade, pais, estado, telefone,
				cep);
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public Long getPaisId() {
		return paisId;
	}

	public Long getEstadoId() {
		return estadoId;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}

}
