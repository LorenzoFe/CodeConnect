package com.suicide.codeConnect_api.web.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String token;
}
