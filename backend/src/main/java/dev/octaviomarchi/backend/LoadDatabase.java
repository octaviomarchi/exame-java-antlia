package dev.octaviomarchi.backend;

import dev.octaviomarchi.backend.model.Produto;
import dev.octaviomarchi.backend.model.ProdutoCosif;
import dev.octaviomarchi.backend.repository.ProdutoCosifRepository;
import dev.octaviomarchi.backend.repository.ProdutoRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Log4j2
@Configuration
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(
            ProdutoRepository produtoRepository,
            ProdutoCosifRepository produtoCosifRepository
    ) {
        return args -> {
            Produto produtoA = new Produto("AAAA", "PRODUTO A", "A");
            Produto produtoB = new Produto("BBBB", "PRODUTO B", "A");
            log.info("Preloading " + produtoA);
            produtoA = produtoRepository.save(produtoA);
            log.info("Preloading " + produtoB);
            produtoB = produtoRepository.save(produtoB);
            ProdutoCosif produtoCosifA = new ProdutoCosif("0101", "TOP", "A", produtoA);
            log.info("Preloading: " + produtoCosifA);
            produtoCosifRepository.save(produtoCosifA);
        };
    }
}
