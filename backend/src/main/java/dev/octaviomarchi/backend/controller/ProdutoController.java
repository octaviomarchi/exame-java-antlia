package dev.octaviomarchi.backend.controller;

import dev.octaviomarchi.backend.dtos.ProductDTO;
import dev.octaviomarchi.backend.dtos.ProdutoCosifDTO;
import dev.octaviomarchi.backend.service.ProdutoCosifService;
import dev.octaviomarchi.backend.service.impl.ProdutoServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@Log4j2
@CrossOrigin(origins = "http://localhost:4200/")
public class ProdutoController {

    @Autowired
    ProdutoServiceImpl productServiceImpl;

    @Autowired
    ProdutoCosifService produtoCosifService;

    @GetMapping()
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDTO> getProducts() {
        log.info("getProducts");
        List<ProductDTO> products = productServiceImpl.getProductsForDropdown();
        return products;
    }

    @GetMapping("/{codigo}/cosif")
    public List<ProdutoCosifDTO> getProdutoCosifPorCodigoDoProduto(@PathVariable String codigo) {
        List<ProdutoCosifDTO> produtoCosifDTOList = produtoCosifService.getAllFromCodigoProduto(codigo);
        return produtoCosifDTOList;
    }
}
