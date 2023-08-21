package com.unifacisa.tap.usuarioservice.service.mapper;

import com.unifacisa.tap.usuarioservice.domain.Usuario;
import com.unifacisa.tap.usuarioservice.service.dto.UsuarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    // INSTANCE é uma forma de referenciar a função de mapeamento usuarioToDTO do nosso UsuarioMapper.
    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    UsuarioDTO usuarioToDTO(Usuario usuario);

    // Inverso
    Usuario DTOtoUsuario(UsuarioDTO dto);

}
