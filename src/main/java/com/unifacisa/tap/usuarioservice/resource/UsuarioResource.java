package com.unifacisa.tap.usuarioservice.resource;

import com.unifacisa.tap.usuarioservice.domain.Usuario;
import com.unifacisa.tap.usuarioservice.service.EntityCrudUtils;
import com.unifacisa.tap.usuarioservice.service.dto.UsuarioDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UsuarioResource  {

    public UsuarioDTO buscar(Long id) {
        return null;
    }

    public List<UsuarioDTO> listar() {
        return null;
    }

    public void salvar(UsuarioDTO dto) {

    }

    public void deletar(Long id) {

    }

    public UsuarioDTO atualizar(UsuarioDTO dto) {
        return null;
    }
}
