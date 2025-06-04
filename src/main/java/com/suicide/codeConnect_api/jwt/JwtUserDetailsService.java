package com.suicide.codeConnect_api.jwt;

import com.suicide.codeConnect_api.entity.Usuario;
import com.suicide.codeConnect_api.exception.UniqueViolationExcption;
import com.suicide.codeConnect_api.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final UsuarioService usuarioService;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.buscarPorEmail(email);
        if (usuario == null){
            throw new UniqueViolationExcption("Usuário com email" + email +"não encontrado.");
        }
        return new JwtUserDetails(usuario);
    }
    public JwtToken getTokenAuthenticated(String email){
        Usuario usuario = usuarioService.buscarPorEmail(email);
        if (usuario == null){
            throw new UniqueViolationExcption("Usuário com email" + email + "não encontrado");
        }
        return JwtUtils.createToken(usuario);
    }
    public Usuario getUsuarioByEmail(String email) {
        Usuario usuario = usuarioService.buscarPorEmail(email);
        if (usuario == null){
            throw new UniqueViolationExcption("Usuário com email " + email + " não encontrado");
        }
        return usuario;
    }

}
