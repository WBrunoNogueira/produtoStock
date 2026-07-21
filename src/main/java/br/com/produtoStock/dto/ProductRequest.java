package br.com.produtoStock.dto;

import java.math.BigDecimal;
// DTO - apresenta umn intermedio para que envie dados que so o cliente pode enviar
public record ProductRequest(
        String name,
        String sku,
        BigDecimal price,
        Integer quantity
) {
}