package com.unifacisa.tap.usuarioservice.service.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class UsuarioBuscaNomeCPFDTO implements Serializable {


    @NotNull(message = "CPF não pode ser nulo")
    private String cpf;

    @NotNull(message = "Nome não pode ser nulo")
    private String nome;

}
