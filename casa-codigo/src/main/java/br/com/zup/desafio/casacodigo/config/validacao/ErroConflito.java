package br.com.zup.desafio.casacodigo.config.validacao;

public class ErroConflito {

	private Integer campo;
	private String mensagem;
	
	public ErroConflito(Integer campo, String mensagem) {
		super();
		this.campo = campo;
		this.mensagem = mensagem;
	}

	public Integer getCampo() {
		return campo;
	}

	public String getMensagem() {
		return mensagem;
	}
	
}