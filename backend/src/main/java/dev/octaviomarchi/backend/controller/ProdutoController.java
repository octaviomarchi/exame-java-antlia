package dev.octaviomarchi.backend.controller;

import dev.octaviomarchi.backend.dtos.ProdutoDTO;
import dev.octaviomarchi.backend.dtos.ProdutoCosifDTO;
import dev.octaviomarchi.backend.service.ProdutoCosifService;
import dev.octaviomarchi.backend.service.impl.ProdutoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "http://localhost:4200/")
public class ProdutoController {

    @Autowired
    ProdutoServiceImpl productServiceImpl;

    @Autowired
    ProdutoCosifService produtoCosifService;

    @GetMapping()
    @Operation(description = "Retorna todos os produtos")
    public ResponseEntity<List<ProdutoDTO>> getProducts() {
        List<ProdutoDTO> produtos = productServiceImpl.getProdutosParaDropdown();
        return ResponseEntity.ok().body(produtos);
    }

    @GetMapping("/{codigoProduto}/cosif")
    @Operation(description = "Retorna todos os Cosif relacionados ao Produto")
    public List<ProdutoCosifDTO> getProdutoCosifListPorCodigoDoProduto(@PathVariable String codigoProduto) {
        List<ProdutoCosifDTO> produtoCosifDTOList = produtoCosifService.getProdutoCosifListDoProduto(codigoProduto);
        return produtoCosifDTOList;
    }
}
