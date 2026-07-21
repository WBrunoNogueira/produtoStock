package br.com.produtoStock.controller;

import br.com.produtoStock.model.Product;
import br.com.produtoStock.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController                   //Define a classe como controller REST
@RequestMapping("/products")   //definiçaõ do endereço do controller
public class ProductController {

    private final ProductService service;         // injeção do service na classe

    public ProductController(ProductService service) {
        this.service = service;
    }

   //POST
    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {

        Product savedProduct = service.create(product);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedProduct);
    }

    //FIND ALL
    @GetMapping
    public ResponseEntity<List<Product>> findAll() {

        List<Product> products = service.findAll();

        return ResponseEntity.ok(products);
    }

    //find-by-id
    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {

        Product product = service.findById(id);

        return ResponseEntity.ok(product);
    }


    //update
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(
            @PathVariable Long id,
            @RequestBody Product product
    ) {

        Product updatedProduct = service.update(id, product);

        return ResponseEntity.ok(updatedProduct);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}