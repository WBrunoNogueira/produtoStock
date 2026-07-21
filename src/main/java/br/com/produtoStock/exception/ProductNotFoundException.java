package br.com.produtoStock.exception;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(Long id) {
        super("Produto não encontrado com o ID: " + id);
    }
}
