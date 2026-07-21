package br.com.produtoStock.service;

import br.com.produtoStock.model.Product;
import br.com.produtoStock.repository.ProductRepository;
import org.springframework.stereotype.Service;

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