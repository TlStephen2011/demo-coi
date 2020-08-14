package com.example.demo;

import com.example.demo.models.Product;
import com.example.demo.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

import java.math.BigDecimal;

@SpringBootApplication
public class DemoApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	@Autowired
	private ProductRepository productRepository;

	@EventListener(ApplicationStartedEvent.class)
	public void onApplicationEventStarted() {
		Product p1 = new Product("First", "Test", new BigDecimal(15.15), "https://starcafe.websites.co.in/dummytemplate/img/product-placeholder.png", 5);
		Product p2 = new Product("Second", "Test", new BigDecimal(15.15), "https://starcafe.websites.co.in/dummytemplate/img/product-placeholder.png", 5);
		Product p3 = new Product("Third", "Test", new BigDecimal(15.15), "https://starcafe.websites.co.in/dummytemplate/img/product-placeholder.png", 5);
		Product p4 = new Product("Fourth", "Test", new BigDecimal(15.15), "https://starcafe.websites.co.in/dummytemplate/img/product-placeholder.png", 5);
		Product p5 = new Product("Fifth", "Test", new BigDecimal(15.15), "https://starcafe.websites.co.in/dummytemplate/img/product-placeholder.png", 5);

		log.info("Saving..." + productRepository.save(p1));
		log.info("Saving..." + productRepository.save(p2));
		log.info("Saving..." + productRepository.save(p3));
		log.info("Saving..." + productRepository.save(p4));
		log.info("Saving..." + productRepository.save(p5));
	}



	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
