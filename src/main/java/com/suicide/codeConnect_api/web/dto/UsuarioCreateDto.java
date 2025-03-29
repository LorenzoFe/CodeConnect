package com.suicide.codeConnect_api.web.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsuarioCreateDto {

    // Aqui vai ser onde faremos algumas validações antes de converte o DTO para Entidade usuario e salvar no banco
    @NotBlank
    private String username;
    @NotBlank
    @Email(message = "Formato do email está invalido", regexp = "^[a-z0-9.+-]+@[a-z0-9.-]+\\.[a-z]{2,}$")
    private String email;
    @NotBlank
    @Size(min = 8, max = 20)
    private String password;
}
