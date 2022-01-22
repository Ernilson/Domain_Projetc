package br.com.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.domain.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
