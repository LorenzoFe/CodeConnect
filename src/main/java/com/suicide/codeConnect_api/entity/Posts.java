package com.suicide.codeConnect_api.entity;


import jakarta.persistence.*;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
@Slf4j
@EntityListeners(AuditingEntityListener.class)
public class Posts implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", nullable = false, unique = false, length = 100)
    private String title;

    @Column(name = "descricao_post", nullable = false)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "usuario_fk")
    private Usuario usuarioFk;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacaoPosts = LocalDateTime.now();

    @Column(name = "image_url", nullable = false)
    private String imageUrl;


}
