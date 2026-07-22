
package br.com.produtoStock.repository;

import br.com.produtoStock.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsBySku(String sku);
    boolean existsBySkuAndIdNot(String sku, Long id);
}

/*

O Repository no Spring
    serve para abstrair a comunicação com o banco de dados. Ele atua como uma ponte entre
    a sua aplicação e o banco, permitindo que você faça operações de CRUD (Criar, Ler, Atualizar, Deletar) e buscas
    complexas sem precisar escrever SQL manualmente

*  Herdará da interface JpaRepository
*       Product -> entidade que o Repository vai gerenciar
*       Long -> tipo do ID da entidade
*
*       Spring disponibilizará os metodos:
*           save()
            findAll()
            findById()
            delete()
            deleteById()
            existsById()
*
* */