package com.example.demo.config;

import com.example.demo.models.Product;
import com.example.demo.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.math.BigDecimal;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ProductRepository repository) {
        return args -> {
            Product p1 = new Product("First", "Test", new BigDecimal(15.15), "https://starcafe.websites.co.in/dummytemplate/img/product-placeholder.png", 5);
            Product p2 = new Product("Second", "Test", new BigDecimal(15.15), "https://starcafe.websites.co.in/dummytemplate/img/product-placeholder.png", 5);
            Product p3 = new Product("Third", "Test", new BigDecimal(15.15), "https://starcafe.websites.co.in/dummytemplate/img/product-placeholder.png", 5);
            Product p4 = new Product("Fourth", "Test", new BigDecimal(15.15), "https://starcafe.websites.co.in/dummytemplate/img/product-placeholder.png", 5);
            Product p5 = new Product("Fifth", "Test", new BigDecimal(15.15), "https://starcafe.websites.co.in/dummytemplate/img/product-placeholder.png", 5);

            log.info("Saving..." + repository.save(p1));
            log.info("Saving..." + repository.save(p2));
            log.info("Saving..." + repository.save(p3));
            log.info("Saving..." + repository.save(p4));
            log.info("Saving..." + repository.save(p5));
        };
    }
}
