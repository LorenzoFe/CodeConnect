package com.suicide.codeConnect_api.web.dto;


import lombok.*;

import java.time.LocalDateTime;

@Data
public class PostsResponseDTO {
    private String id;
    private String title;
    private String descricao;
    private String nomeUsuario;
    private LocalDateTime dataCriacaoPosts;
}
