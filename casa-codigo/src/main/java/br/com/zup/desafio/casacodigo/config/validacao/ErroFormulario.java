package br.com.zup.desafio.casacodigo.config.validacao;

public class ErroFormulario {
	
	private String campo;
	private String mensagem;
	
	public ErroFormulario(String campo, String mensagem) {
		super();
		this.campo = campo;
		this.mensagem = mensagem;
	}
	
	public String getCampo() {
		return campo;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	
	

}
