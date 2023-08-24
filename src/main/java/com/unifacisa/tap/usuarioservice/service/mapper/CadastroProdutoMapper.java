package com.unifacisa.tap.usuarioservice.service.mapper;

import com.unifacisa.tap.usuarioservice.domain.CadastroProduto;
import com.unifacisa.tap.usuarioservice.service.dto.CadastroProdutoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CadastroProdutoMapper {

    /**
     * INSTANCE é uma forma de referenciar a função de mapeamento produtoToDTO do nosso CadastroProdutoMapper
     * O código CadastroProdutoMapper INSTANCE cria uma instância do mapeador definido na interface CadastroProdutoMapper.
     * Essa instância é armazenada na variável INSTANCE para ser usada posteriormente para realizar os mapeamentos.
     */
    CadastroProdutoMapper INSTANCE = Mappers.getMapper(CadastroProdutoMapper.class);

    CadastroProdutoDTO cadastroToDTO(CadastroProduto cadastroProduto);

    CadastroProduto dtoToProduto(CadastroProdutoDTO dto);

}
