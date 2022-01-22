package br.com.domain;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.domain.entities.Client;
import br.com.domain.entities.Order;
import br.com.domain.entities.OrderItem;
import br.com.domain.entities.OrderStatus;
import br.com.domain.entities.Product;
import br.com.domain.repository.ClienteRepository;
import br.com.domain.repository.OrderItemRepository;
import br.com.domain.repository.OrderRepository;
import br.com.domain.repository.ProductRepository;

@SpringBootApplication
public class DomainApplication implements CommandLineRunner{
	
	@Autowired
	private ClienteRepository cr;
	
	@Autowired
	private ProductRepository pr;
	
	@Autowired
	private OrderRepository or;
	
	@Autowired
	private OrderItemRepository oIr;

	public static void main(String[] args) {
		SpringApplication.run(DomainApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("teste");
		
		Client c1 = new Client();
		c1.setName("teste1");
		c1.setEmail("teste@teste.com");
		
		cr.save(c1);
		
		Product p1 = new Product(null, "Tv", 1000.0);
		Product p2 = new Product(null, "Mouse", 40.0);
		Product p3 = new Product(null, "Pc", 1200.0);
	
		pr.saveAll(Arrays.asList(p1,p2,p3));
		
		Order o1 = new Order(null,Instant.parse("2021-04-18T11:25:09Z"), OrderStatus.PAID, c1);
		Order o2 = new Order(null,Instant.parse("2021-04-18T13:30:00Z"), OrderStatus.WAITTING, c1);
		
		or.saveAll(Arrays.asList(o1,o2));
		
		OrderItem i1 = new OrderItem(null, 1, 1000.0, p1, o1);
		OrderItem i2 = new OrderItem(null, 2, 40.0, p2, o1);
		OrderItem i3 = new OrderItem(null, 1, 40.0, p2, o2);
		OrderItem i4 = new OrderItem(null, 1, 12000.0, p3, o2);
		
		oIr.saveAll(Arrays.asList(i1,i2,i3,i4));
	}

}
