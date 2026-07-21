package br.com.produtoStock.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;
// DTO - apresenta umn intermedio para que envie dados que so o cliente pode enviar
public record ProductRequest(

        @NotBlank(message = "O nome é obrigatório")
        String name,

        @NotBlank(message = "O SKU é obrigatório")
        String sku,

        @NotNull(message = "O preço é obrigatório")
        @Positive(message = "O preço deve ser maior que zero")
        BigDecimal price,

        @NotNull(message = "A quantidade é obrigatória")
        @PositiveOrZero(message = "A quantidade não pode ser negativa")
        Integer quantity

){
}