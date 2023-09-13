package com.unifacisa.tap.usuarioservice.resource.contract;

import com.unifacisa.tap.usuarioservice.service.dto.ProdutoDTO;
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

@Tag(name = "Produto")
public interface ProdutoContract {

    @Operation(summary = "Retorna lista de produtos", description = "Lista de produtos retornada com sucesso")
    @ApiResponse(responseCode = "200", description = "Lista de produtos retornada com sucesso",
            content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    array = @ArraySchema(schema = @Schema(implementation =ProdutoDTO.class)))})
    @ApiResponse(responseCode = "500", description = "Internal Server Error",
            content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Exception.class))})
    ResponseEntity<List<ProdutoDTO>> listarProdutos();

    @Operation(summary = "Retorna produto por id ", description = "Produto retornado com sucesso")
    @ApiResponse(responseCode = "200", description = "Produto retornado com sucesso",
            content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ProdutoDTO.class))})
    @ApiResponse(responseCode = "500", description = "Internal Server Error",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Exception.class))})
    @ApiResponse(responseCode = "404", description = "Not Found",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = NotFoundException.class))})
    ResponseEntity<ProdutoDTO> buscarProdutoPorId(@PathVariable Long id);

    @Operation(summary = "Salva novo produto", description = "Produto salvo com sucesso")
    @ApiResponse(responseCode = "200", description = "Produto salvo com sucesso",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ProdutoDTO.class))})
    @ApiResponse(responseCode = "500", description = "Internal Server Error",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Exception.class))})
    ResponseEntity<ProdutoDTO> salvarProduto(@RequestBody ProdutoDTO produtoDTO);

    @Operation(summary = "Exclui produto por id", description = "Produto removido com sucesso")
    @ApiResponse(responseCode = "200", description = "Produto removido com sucesso")
    @ApiResponse(responseCode = "500", description = "Internal Server Error",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Exception.class))})
    @ApiResponse(responseCode = "404", description = "Not Found",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = NotFoundException.class))})
    ResponseEntity<Void> excluirProduto(@PathVariable Long id);

    @Operation(summary = "Atualiza produto", description = "Produto atualizado com sucesso")
    @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso",
            content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ProdutoDTO.class))})
    @ApiResponse(responseCode = "500", description = "Internal Server Error",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Exception.class))})
    @ApiResponse(responseCode = "404", description = "Not Found",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = NotFoundException.class))})
    ResponseEntity<ProdutoDTO> atualizarProduto(@RequestBody ProdutoDTO produtoAtualizado);
}
