package com.suicide.codeConnect_api.web.controller;


import com.suicide.codeConnect_api.entity.Usuario;
import com.suicide.codeConnect_api.repository.UsuarioRepository;
import com.suicide.codeConnect_api.service.UsuarioService;
import com.suicide.codeConnect_api.web.dto.UsuarioCreateDto;
import com.suicide.codeConnect_api.web.dto.UsuarioResponseDto;
import com.suicide.codeConnect_api.web.dto.mapper.UsuarioMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<UsuarioResponseDto> create(@Valid @RequestBody UsuarioCreateDto createDto){
        Usuario user = usuarioService.salvar(UsuarioMapper.toUsuario(createDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toDto(user));
    }
}
