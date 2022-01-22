package br.com.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.domain.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
