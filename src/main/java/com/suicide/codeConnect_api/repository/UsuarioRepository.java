package com.suicide.codeConnect_api.repository;

import com.suicide.codeConnect_api.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
