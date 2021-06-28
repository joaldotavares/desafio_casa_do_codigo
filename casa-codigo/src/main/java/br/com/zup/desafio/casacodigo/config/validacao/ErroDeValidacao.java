package br.com.zup.desafio.casacodigo.config.validacao;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErroDeValidacao {
	
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ErroConflito> handlerData(DataIntegrityViolationException exception){
		
		ErroConflito erro = new ErroConflito(HttpStatus.CONFLICT.value(), exception.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
	}
}
