package com.unifacisa.tap.usuarioservice.resource.contract;

import com.unifacisa.tap.usuarioservice.service.dto.ProdutoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

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


    ResponseEntity<ProdutoDTO> buscarProdutoPorId(@PathVariable Long id);

}
