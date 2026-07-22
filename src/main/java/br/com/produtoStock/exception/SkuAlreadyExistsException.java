package br.com.produtoStock.exception;

public class SkuAlreadyExistsException extends  RuntimeException {

        public  SkuAlreadyExistsException(String sku){
            super("Já existe um produto cadastrado com o SKU: " + sku );
        }
}
