package com.suicide.codeConnect_api.web.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Data
public class PostsResponseDTO {
    private long id;
    private String title;
    private String descricao;
    private String nomeUsuario;
    private String imageUrl;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataCriacaoPosts;
}
