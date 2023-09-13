package com.unifacisa.tap.usuarioservice.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class UsuarioDTO implements Serializable {

    private Long id;

    @NotNull(message = "CPF não pode ser nulo")
    @Schema(description = "Cpf usuario", example = "000.000.000-00")
    private String cpf;

    @NotNull(message = "Nome não pode ser nulo")
    @Schema(description = "Nome usuario", example = "Maria da Silva")
    private String nome;

    @NotNull(message = "Email não pode ser nulo")
    @Email(message = "Email Inválido")
    @Schema(description = "Email usuario", example = "example@mail.com")
    private String email;

    @NotNull(message = "Telefone não pode ser nulo")
    @NotBlank(message = "Coloque um telefone")
    @Schema(description = "telefone usuario", example = "(DDD)90000-0000")
    private String telefone;

    @NotNull(message = "Data de nascimento não pode ser nulo")
    @Schema(description = "Data de nascimento usuario", example = "dd/MM/aaaa")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    private Boolean admin;

}
