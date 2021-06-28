package br.com.zup.desafio.casacodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.desafio.casacodigo.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

}
