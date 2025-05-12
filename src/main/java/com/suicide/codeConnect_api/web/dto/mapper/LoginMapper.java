package com.suicide.codeConnect_api.web.dto.mapper;

import com.suicide.codeConnect_api.entity.Usuario;
import com.suicide.codeConnect_api.web.dto.LoginResponseDTO;
import org.modelmapper.ModelMapper;

public class LoginMapper {
    public static LoginResponseDTO toLoginDto(Usuario usuario){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(usuario, LoginResponseDTO.class);
    }
}
