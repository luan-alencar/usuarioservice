package com.unifacisa.tap.usuarioservice.service.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ProdutoDTO {

    private Long id;
    @NotNull(message = "Nome não pode ser nulo")
    private String nome;

    @NotNull(message = "Nome não pode ser nulo")
    private Double preco;

}
