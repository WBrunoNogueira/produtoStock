package br.com.produtoStock.controller;

import br.com.produtoStock.dto.ProductRequest;
import br.com.produtoStock.dto.ProductResponse;
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
   public ResponseEntity<ProductResponse> create(@RequestBody ProductRequest request) {

       ProductResponse response = service.create(request);

       return ResponseEntity
               .status(HttpStatus.CREATED)
               .body(response);
   }

    //FIND ALL
    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    //find-by-id
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable Long id) {

        ProductResponse response = service.findById(id);

        return ResponseEntity.ok(response);
    }


    //update
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(
            @PathVariable Long id,
            @RequestBody ProductRequest request
    ) {

        ProductResponse response = service.update(id, request);

        return ResponseEntity.ok(response);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}