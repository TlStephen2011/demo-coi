package com.example.demo;

import com.example.demo.models.Product;
import com.example.demo.repositories.ProductRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private ProductRepository productRepository;

	@BeforeTestMethod
	void init() {
		Product p1 = new Product("First", "Test", new BigDecimal(15.15), "https://starcafe.websites.co.in/dummytemplate/img/product-placeholder.png", 5);
		Product p2 = new Product("Second", "Test", new BigDecimal(15.15), "https://starcafe.websites.co.in/dummytemplate/img/product-placeholder.png", 5);
		Product p3 = new Product("Third", "Test", new BigDecimal(15.15), "https://starcafe.websites.co.in/dummytemplate/img/product-placeholder.png", 5);
		Product p4 = new Product("Fourth", "Test", new BigDecimal(15.15), "https://starcafe.websites.co.in/dummytemplate/img/product-placeholder.png", 5);
		Product p5 = new Product("Fifth", "Test", new BigDecimal(15.15), "https://starcafe.websites.co.in/dummytemplate/img/product-placeholder.png", 5);

		productRepository.save(p1);
		productRepository.save(p2);
		productRepository.save(p3);
		productRepository.save(p4);
		productRepository.save(p5);
	}

	@Test
	void contextLoads() {
		org.junit.jupiter.api.Assertions.assertNotNull(productRepository);
	}

	@Test
	void poop() {
		List<Product> products = productRepository.findAll();
		org.junit.jupiter.api.Assertions.assertEquals(products.size(), 5);
	}

}
