package br.com.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.domain.entities.Client;

@Repository
public interface ClienteRepository extends JpaRepository<Client, Long>{

}
