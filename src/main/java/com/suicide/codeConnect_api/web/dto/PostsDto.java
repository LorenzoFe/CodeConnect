package com.suicide.codeConnect_api.web.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PostsDto {

    @NotBlank(message = "Titulo Obrigatorio")
    private String title;
    @NotBlank(message = "Descrição é obrigatorio")
    private String descricaoPost;
    @NotNull(message = "ID do usuário é obrigatorio")
    private Long usuarioId;

}
