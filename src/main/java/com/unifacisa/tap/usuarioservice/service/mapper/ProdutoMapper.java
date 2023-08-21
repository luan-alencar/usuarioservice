package com.unifacisa.tap.usuarioservice.service.mapper;

import com.unifacisa.tap.usuarioservice.domain.Produto;
import com.unifacisa.tap.usuarioservice.service.dto.ProdutoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    // INSTANCE é uma forma de referenciar a função de mapeamento produtoToDTO do nosso ProdutoMapper.
    ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);

    ProdutoDTO produtoToDTO(Produto produto);

    Produto dtoToProduto(ProdutoDTO dto);
}
