package com.suicide.codeConnect_api.entity;


import jakarta.persistence.*;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
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

    @Lob
    @Column(name = "descricao_post", nullable = false)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "usuario_fk")
    private Usuario usuarioFk;

    @CreatedDate
    @Column(name = "data_criacao", updatable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "image_url")
    private String imageUrl;



}
