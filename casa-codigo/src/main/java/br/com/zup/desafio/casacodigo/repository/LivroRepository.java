package br.com.zup.desafio.casacodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.desafio.casacodigo.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
