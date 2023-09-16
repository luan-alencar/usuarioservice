package com.unifacisa.tap.usuarioservice.service;

import com.unifacisa.tap.usuarioservice.domain.Usuario;
import com.unifacisa.tap.usuarioservice.repository.UsuarioRepository;
import com.unifacisa.tap.usuarioservice.service.dto.UsuarioBuscaNomeCPFDTO;
import com.unifacisa.tap.usuarioservice.service.dto.UsuarioDTO;
import com.unifacisa.tap.usuarioservice.service.exception.RegraNegocioException;
import com.unifacisa.tap.usuarioservice.service.mapper.UsuarioMapper;
import com.unifacisa.tap.usuarioservice.utils.ConstantsUtils;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @SneakyThrows
    public UsuarioDTO buscarUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("O usuário não existe."));
        return usuarioMapper.INSTANCE.usuarioToDTO(usuario);
    }

    public List<UsuarioDTO> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(UsuarioMapper.INSTANCE::usuarioToDTO)
                .collect(Collectors.toList());
    }

    public List<UsuarioBuscaNomeCPFDTO> findUsuariosByNomeAndCpf(String nome, String cpf) {
        List<Usuario> usuarios = usuarioRepository.findUsuariosByNomeAndCpf(nome, cpf);
        return UsuarioMapper.INSTANCE.usuarioByNomaAndCPFDTO(usuarios);
    }

    @SneakyThrows
    public UsuarioDTO save(Usuario usuario, MultipartFile file) {
        try {
            if (Objects.nonNull(file)) {
                byte[] bytes = file.getBytes();
                if (bytes.length == 0) {
                    throw new RegraNegocioException(ConstantsUtils.ARQUIVO_VAZIO);
                }
                usuario.setImagem(bytes);
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new RegraNegocioException(e.getMessage());
        }

        return this.salvarUsuario(usuario);
    }

    public UsuarioDTO salvarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
        UsuarioDTO dto = usuarioMapper.usuarioToDTO(usuario);
        return UsuarioMapper.INSTANCE.usuarioToDTO(usuario);
    }

    public void excluirUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

}
