package com.unifacisa.tap.usuarioservice.repository;

import com.unifacisa.tap.usuarioservice.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findUsuariosByNomeAndCpf(@Param("nome") String nome, @Param("cpf") String cpf);

}
