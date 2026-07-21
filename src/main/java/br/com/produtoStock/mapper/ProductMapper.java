package br.com.produtoStock.mapper;

import br.com.produtoStock.dto.ProductRequest;
import br.com.produtoStock.dto.ProductResponse;
import br.com.produtoStock.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toEntity(ProductRequest request) {
        return new Product(
                request.name(),
                request.sku(),
                request.price(),
                request.quantity()
        );
    }

    public ProductResponse toResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getSku(),
                product.getPrice(),
                product.getQuantity()
        );
    }

    public void updateEntity(ProductRequest request, Product product) {
        product.setName(request.name());
        product.setSku(request.sku());
        product.setPrice(request.price());
        product.setQuantity(request.quantity());
    }
}