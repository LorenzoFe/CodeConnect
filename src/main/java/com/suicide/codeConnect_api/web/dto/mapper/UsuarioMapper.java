package com.suicide.codeConnect_api.web.dto.mapper;

import com.suicide.codeConnect_api.entity.Usuario;
import com.suicide.codeConnect_api.web.dto.UsuarioCreateDto;
import com.suicide.codeConnect_api.web.dto.UsuarioResponseDto;
import org.modelmapper.ModelMapper;

public class UsuarioMapper {


    // converte o UsuarioDTO para entidade Usuario
    public static Usuario toUsuario(UsuarioCreateDto createDto){
        return new ModelMapper().map(createDto, Usuario.class);
    }

    // Converte a entidade Usuario para UsuarioDTO
    public static UsuarioResponseDto toDto(Usuario usuario){
        return new ModelMapper().map(usuario, UsuarioResponseDto.class);
    }
}
