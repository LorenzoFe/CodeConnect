package com.suicide.codeConnect_api.web.controller;

import com.suicide.codeConnect_api.entity.Usuario;
import com.suicide.codeConnect_api.jwt.JwtToken;
import com.suicide.codeConnect_api.jwt.JwtUserDetailsService;
import com.suicide.codeConnect_api.web.dto.LoginDto;
import com.suicide.codeConnect_api.web.dto.LoginResponseDTO;
import com.suicide.codeConnect_api.web.exception.ErrorMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class AutenticacaoController {

    private final JwtUserDetailsService detailsService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/auth")
    public ResponseEntity<?> autenticar(@RequestBody @Valid LoginDto dto, HttpServletRequest request){
        log.info("Processo de autenticação pelo login {}", dto.getEmail());
            //autentica o usuário
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword());
            authenticationManager.authenticate(authenticationToken);
            // cria o token JWT
            JwtToken token = detailsService.getTokenAuthenticated(dto.getEmail());

            //busca o usuário completo pra pegar id e email
            Usuario usuario = detailsService.getUsuarioByEmail(dto.getEmail());

            LoginResponseDTO responseDTO = new LoginResponseDTO(
                    usuario.getId(),
                    usuario.getName(),
                    usuario.getEmail(),
                    token.getToken()
            );
            return ResponseEntity.ok(responseDTO);

    }
}
