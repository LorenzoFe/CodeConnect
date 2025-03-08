package com.suicide.codeConnect_api.web.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsuarioCreateDto {

    // Aqui vai ser onde faremos algumas validações antes de converte o DTO para Entidade usuario e salvar no banco
    private String username;
    private String email;
    private String password;
}
