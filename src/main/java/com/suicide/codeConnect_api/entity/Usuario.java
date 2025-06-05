package com.suicide.codeConnect_api.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @Column(name = "username", nullable = true, unique = false, length = 100)
    private String username;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "password", nullable = false, length = 200)
    private String password;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao = LocalDateTime.now();;

    @Lob
    @Column(name = "descricao", nullable = true, columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "foto_url")
    private String fotoUrl;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuarios = (Usuario) o;
        return Objects.equals(id, usuarios.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "id=" + id +
                '}';
    }
}
