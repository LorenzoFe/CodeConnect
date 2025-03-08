package com.suicide.codeConnect_api.web.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsuarioResponseDto {

    // Aqui vai ser o corpo da resposta que o Usuario ira ver para os recursos de Usuário
    private long id;
    private String username;
    private String email;
}
