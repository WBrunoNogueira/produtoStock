package br.com.produtoStock.dto;

import java.math.BigDecimal;

public record ProductResponse(
        Long id,
        String name,
        String sku,
        BigDecimal price,
        Integer quantity
) {
}

//O id aparece apenas no Response porque é gerado pelo banco.
//
//Crie esse ProductResponse. O próximo passo será criar o Mapper, que vai converter ProductRequest ↔ Product ↔ ProductResponse.