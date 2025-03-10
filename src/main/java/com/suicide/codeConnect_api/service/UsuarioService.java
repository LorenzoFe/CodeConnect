package com.suicide.codeConnect_api.service;

import com.suicide.codeConnect_api.entity.Usuario;
import com.suicide.codeConnect_api.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;


    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario autenticar(String email, String password) {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Usuario não encontrado"));
        if (!usuario.getPassword().equals(password)){
            throw new IllegalArgumentException("Senha incorreta");
        }
        return usuario;
    }
}
