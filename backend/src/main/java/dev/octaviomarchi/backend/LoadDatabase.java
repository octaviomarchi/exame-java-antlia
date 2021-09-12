package dev.octaviomarchi.backend;

import dev.octaviomarchi.backend.models.Product;
import dev.octaviomarchi.backend.repositories.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Log4j2
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(ProductRepository productRepository) {
        return args -> {
            log.info("Preloading " + productRepository.save(new Product("AAAA", "PRODUTO A", "A")));
            log.info("Preloading " + productRepository.save(new Product("BBBB", "PRODUTO B", "A")));
        };
    }
}
