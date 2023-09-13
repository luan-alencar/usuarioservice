package com.unifacisa.tap.usuarioservice.service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDTO {

    @Schema(description = "Nome do produto", example = "Boneca da Barbie")
    private String nome;

    @Schema(description = "Preço do produto", example = "99.99")
    private Double preco;

}
