package br.com.produtoStock.service;

import br.com.produtoStock.dto.ProductRequest;
import br.com.produtoStock.dto.ProductResponse;
import br.com.produtoStock.exception.ProductNotFoundException;
import br.com.produtoStock.mapper.ProductMapper;
import br.com.produtoStock.model.Product;
import br.com.produtoStock.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    public ProductService(
            ProductRepository repository,
            ProductMapper mapper
    ) {
        this.repository = repository;
        this.mapper = mapper;
    }


    //create
    public ProductResponse create(ProductRequest request) {

        Product product = mapper.toEntity(request);

        Product savedProduct = repository.save(product);

        return mapper.toResponse(savedProduct);
    }

    //FIND-ALL
    public List<ProductResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    //FIND-BY-ID
    public ProductResponse findById(Long id) {

        Product product = repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        return mapper.toResponse(product);
    }
    //update
    public ProductResponse update(Long id, ProductRequest request) {

        Product existingProduct = repository.findById(id)
               .orElseThrow(() -> new ProductNotFoundException(id));

        mapper.updateEntity(request, existingProduct);

        Product updatedProduct = repository.save(existingProduct);

        return mapper.toResponse(updatedProduct);
    }

    //delete
    public void delete(Long id) {

        Product product = repository.findById(id)
               .orElseThrow(() -> new ProductNotFoundException(id));

        repository.delete(product);
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