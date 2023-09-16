package com.unifacisa.tap.usuarioservice.resource;

import com.unifacisa.tap.usuarioservice.resource.contract.UsuarioContract;
import com.unifacisa.tap.usuarioservice.domain.Usuario;
import com.unifacisa.tap.usuarioservice.service.UsuarioService;
import com.unifacisa.tap.usuarioservice.service.dto.UsuarioBuscaNomeCPFDTO;
import com.unifacisa.tap.usuarioservice.service.dto.UsuarioDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.unifacisa.tap.usuarioservice.utils.ConstantsUtils.USUARIOS_ENDPOINT;

@RestController
@RequiredArgsConstructor
@RequestMapping(USUARIOS_ENDPOINT)
public class UsuarioResource implements UsuarioContract {

    private final UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios() {
        List<UsuarioDTO> usuarios = usuarioService.listarUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> buscarUsuarioPorId(@PathVariable Long id) {
        UsuarioDTO usuarioDTO = usuarioService.buscarUsuario(id);
        return ResponseEntity.ok(usuarioDTO);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<UsuarioBuscaNomeCPFDTO>> buscarUsuariosPorNomeECpf(
            @RequestParam("nome") String nome,
            @RequestParam("cpf") String cpf) {

        List<UsuarioBuscaNomeCPFDTO> usuarios = usuarioService.findUsuariosByNomeAndCpf(nome, cpf);
        if (usuarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(usuarios);
        }
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> salvarUsuario(@RequestBody Usuario usuario, MultipartFile file) {
        UsuarioDTO usuarioDTO = usuarioService.save(usuario, file);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirUsuario(@PathVariable Long id) {
        usuarioService.excluirUsuario(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<UsuarioDTO> atualizarUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.salvarUsuario(usuario));
    }
}
