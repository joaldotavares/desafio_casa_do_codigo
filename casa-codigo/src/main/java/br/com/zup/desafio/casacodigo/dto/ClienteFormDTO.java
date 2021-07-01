package br.com.zup.desafio.casacodigo.dto;

import br.com.zup.desafio.casacodigo.model.Cliente;

public class ClienteFormDTO {

	private Long Id;
	private String email;
	private String nome;
	private String sobrenome;
	private String cpfOuCnpj;
	private String endereco;
	private String complemento;
	private String cidade;
	private Long pais;
	private Long estado;
	private String telefone;
	private String cep;

	public ClienteFormDTO(Cliente cliente) {
		this.Id = cliente.getId();
		this.email = cliente.getEmail();
		this.nome = cliente.getNome();
		this.sobrenome = cliente.getSobrenome();
		this.cpfOuCnpj = cliente.getCpfOuCnpj();
		this.endereco = cliente.getEndereco();
		this.complemento = cliente.getComplemento();
		this.cidade = cliente.getCidade();
		this.pais = cliente.getPais().getId();
		if (cliente.getEstado() == null) {
			estado = null;
		} else {
			this.estado = cliente.getEstado().getId();
		}
		this.telefone = cliente.getTelefone();
		this.cep = cliente.getCep();
	}

	public Long getId() {
		return Id;
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

	public Long getPais() {
		return pais;
	}

	public Long getEstado() {
		return estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}

}
