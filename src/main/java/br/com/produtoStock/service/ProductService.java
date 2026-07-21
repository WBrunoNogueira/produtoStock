package br.com.produtoStock.service;

import br.com.produtoStock.model.Product;
import br.com.produtoStock.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    //create
    public Product create(Product product){
        return repository.save(product);
    }

    //FIND-ALL
    public List<Product> findAll(){
        return repository.findAll();
    }

    //FIND-BY-ID
    public Product findById(Long id) {
        return repository.findById(id)
                .orElseThrow();
    }

    //update
    public Product update(Long id, Product product) {

        Product existingProduct = repository.findById(id)
                .orElseThrow();

        existingProduct.setName(product.getName());
        existingProduct.setSku(product.getSku());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());

        return repository.save(existingProduct);
    }


}


//No ecossistema Spring, a camada Service é ondefica a lógica de negócio do seu sistema. Ela recebe
//os dados brutos vindos do Controller, aplica as regras, validações e cálculos necessários,
//e decide quando salvar, alterar ou buscar dados interagindo com a camada de banco de dados (Repository)

//    @service -> informa que a classe pertence a camada de serviço

//    private final ProductRepository repository; -> Service precisa do banco, portando atravez do construtor o SPRING injeta a instancia do ProductRepository no Service
//ProductService
//      ↓
//ProductRepository
//      ↓
//Banco de dados