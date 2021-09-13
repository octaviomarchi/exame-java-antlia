package dev.octaviomarchi.backend.controller;

import dev.octaviomarchi.backend.dtos.ProductDTO;
import dev.octaviomarchi.backend.dtos.ProdutoCosifDTO;
import dev.octaviomarchi.backend.service.ProdutoCosifService;
import dev.octaviomarchi.backend.service.impl.ProdutoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProdutoController {

    @Autowired
    ProdutoServiceImpl productServiceImpl;

    @Autowired
    ProdutoCosifService produtoCosifService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDTO> getProducts() {
        List<ProductDTO> products = productServiceImpl.getProductsForDropdown();
        return products;
    }

    @GetMapping("/{codigo}/cosif")
    public List<ProdutoCosifDTO> getProdutoCosifPorCodigoDoProduto(@PathVariable String codigo) {
        List<ProdutoCosifDTO> produtoCosifDTOList = produtoCosifService.getAllFromCodigoProduto(codigo);
        return produtoCosifDTOList;
    }
}
