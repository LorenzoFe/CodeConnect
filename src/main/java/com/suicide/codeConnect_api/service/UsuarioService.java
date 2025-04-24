package com.suicide.codeConnect_api.service;

import com.suicide.codeConnect_api.entity.Usuario;
import com.suicide.codeConnect_api.exception.EmailUniqueViolationException;
import com.suicide.codeConnect_api.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario salvar(Usuario usuario) {
        try {
            return usuarioRepository.save(usuario);
        } catch (org.springframework.dao.DataIntegrityViolationException ex){
            throw new EmailUniqueViolationException(String.format("Email {%s} já cadastrado", usuario.getEmail()));
        }
    }

    @Transactional
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Usuario id=%s não encontrado", id))
        );
    }

    @Transactional
    public Usuario autenticar(String email, String password) {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Usuario não encontrado"));
        if (!usuario.getPassword().equals(password)){
            throw new IllegalArgumentException("Senha incorreta");
        }
        return usuario;
    }

    @Transactional
    public Usuario editarSenha(Long id, String senhaAtual, String novaSenha, String confirmaSenha) {
            if (!novaSenha.equals(confirmaSenha)){
                throw new RuntimeException("Nova senha está diferente da Confirma senha");
            }
            Usuario user = buscarPorId(id);
            if (!user.getPassword().equals(senhaAtual)){
                throw new RuntimeException("Senha atual errada");
            }
            user.setPassword(novaSenha);
            return user;
    }
    @Transactional
    public Usuario buscarPorEmail(String email) {
            return usuarioRepository.findByEmail(email).orElseThrow(
                    () -> new EntityNotFoundException(" email não encontrado")
            );
    }
    @Transactional
    public List<Usuario> listarTodos(){
        return usuarioRepository.findAll();
    }
}
