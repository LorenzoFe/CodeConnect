package com.suicide.codeConnect_api.web.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PostsDto {

    @NotBlank
    private String Title;
    @NotBlank
    private String descricaoPost;

    @NotBlank
    private String tag;

    private LocalDateTime dataCriacao;

}
