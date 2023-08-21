package com.unifacisa.tap.usuarioservice.service;

import com.unifacisa.tap.usuarioservice.repository.UsuarioRepository;
import com.unifacisa.tap.usuarioservice.service.dto.UsuarioDTO;
import com.unifacisa.tap.usuarioservice.service.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioDTO buscar(Long id) {
        return usuarioMapper.usuarioToDTO(usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException()));
    }

    public List<UsuarioDTO> listarUsuarios() {
        return null;
    }

    public void salvar(UsuarioDTO dto) {
        usuarioRepository.save(usuarioMapper.DTOtoUsuario(dto));
    }

    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }

    public UsuarioDTO atualizar(UsuarioDTO dto) {
        this.salvar(dto);
        return dto;
    }
}
