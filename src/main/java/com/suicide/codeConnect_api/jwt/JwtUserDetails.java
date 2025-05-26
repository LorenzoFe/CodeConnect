package com.suicide.codeConnect_api.jwt;

import com.suicide.codeConnect_api.entity.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class JwtUserDetails  extends User {
    private Usuario usuario;

    public JwtUserDetails(Usuario usuario) {
        super(usuario.getEmail(), usuario.getPassword(), AuthorityUtils.NO_AUTHORITIES);
        this.usuario = usuario;
    }

    public long getId(){
        return this.usuario.getId();
    }
    public String getEmail(){
        return this.usuario.getEmail();
    }

    public Usuario getUsuario(){
        return this.usuario;
    }

}
