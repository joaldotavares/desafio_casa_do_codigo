package br.com.zup.desafio.casacodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.desafio.casacodigo.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
