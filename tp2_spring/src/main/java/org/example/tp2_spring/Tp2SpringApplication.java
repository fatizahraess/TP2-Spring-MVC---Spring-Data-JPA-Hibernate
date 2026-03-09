package org.example.tp2_spring;

import org.example.tp2_spring.entities.Product;
import org.example.tp2_spring.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;
import org.springframework.boot.security.autoconfigure.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Tp2SpringApplication {

    public static void main(String[] args) {

        SpringApplication.run(Tp2SpringApplication.class, args);
    }

    @Bean
public CommandLineRunner start(ProductRepository productRepository){
        return args -> {
    productRepository.save(Product.builder()
                    .name("Computer")
                    .price(5400)
                    .quantity(12)
            .build());
            productRepository.save(Product.builder()
                    .name("Printer")
                    .price(1200)
                    .quantity(11)
                    .build());
            productRepository.save(Product.builder()
                    .name("Smart Phone")
                    .price(12000)
                    .quantity(33)
                    .build());
            productRepository.findAll().forEach(p ->{
                System.out.println(p.toString());
                    });
        };
    }
}
