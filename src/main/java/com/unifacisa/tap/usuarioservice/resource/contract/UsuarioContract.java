package com.unifacisa.tap.usuarioservice.resource.contract;

import com.unifacisa.tap.usuarioservice.service.dto.UsuarioDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import javassist.NotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Usuario")
public interface UsuarioContract {

    @Operation(summary = "Retorna lista de usuarios", description = "Lista de usuarios retornada com sucesso")
    @ApiResponse(responseCode = "200", description = "Lista de usuarios retornada com sucesso",
            content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = UsuarioDTO.class)))})
    @ApiResponse(responseCode = "500", description = "Internal Server Error",
            content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Exception.class))})
        ResponseEntity<List<UsuarioDTO>> listarUsuarios();

    @Operation(summary = "Retorna usuario por id", description = "Usuario retornado com sucesso")
    @ApiResponse(responseCode = "200", description = "Usuario retornado com sucesso",
            content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = UsuarioDTO.class))})
    @ApiResponse(responseCode = "500", description = "Internal Server Error",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Exception.class))})
    @ApiResponse(responseCode = "404", description = "Not Found",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = NotFoundException.class))})
    ResponseEntity<UsuarioDTO> buscarUsuarioPorId(@PathVariable Long id);

    @Operation(summary = "Salva novo usuario", description = "Usuario salvo com sucesso")
    @ApiResponse(responseCode = "200", description = "Usuario salvo com sucesso",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = UsuarioDTO.class))})
    @ApiResponse(responseCode = "500", description = "Internal Server Error",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Exception.class))})
    @ApiResponse(responseCode = "400", description = "Bad Request",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Exception.class))})
    ResponseEntity<UsuarioDTO> salvarUsuario(@RequestBody UsuarioDTO usuarioDTO);

    @Operation(summary = "Exclui usuario por id", description = "Usuario removido com sucesso")
    @ApiResponse(responseCode = "200", description = "Usuario removido com sucesso")
    @ApiResponse(responseCode = "500", description = "Internal Server Error",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Exception.class))})
    @ApiResponse(responseCode = "404", description = "Not Found",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = NotFoundException.class))})
    ResponseEntity<Void> excluirUsuario(@PathVariable Long id);

    @Operation(summary = "Atualiza usuario", description = "Usuario atualizado com sucesso")
    @ApiResponse(responseCode = "200", description = "Usuario atualizado com sucesso",
            content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = UsuarioDTO.class))})
    @ApiResponse(responseCode = "500", description = "Internal Server Error",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Exception.class))})
    @ApiResponse(responseCode = "404", description = "Not Found",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = NotFoundException.class))})
    @ApiResponse(responseCode = "400", description = "Bad Request",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Exception.class))})
    ResponseEntity<UsuarioDTO> atualizarUsuario(@RequestBody UsuarioDTO dto);


}
