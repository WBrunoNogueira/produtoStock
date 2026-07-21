package br.com.produtoStock.controller;

import br.com.produtoStock.model.Product;
import br.com.produtoStock.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController                   //Define a classe como controller REST
@RequestMapping("/products")   //definiçaõ do endereço do controller
public class ProductController {

    private final ProductService service;         // injeção do service na classe

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping        //endpont de POST
    public ResponseEntity<Product> create(@RequestBody Product product) {

        Product savedProduct = service.create(product);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedProduct);
    }
}