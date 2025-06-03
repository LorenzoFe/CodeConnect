package com.suicide.codeConnect_api.web.controller;


import com.suicide.codeConnect_api.entity.Usuario;
import com.suicide.codeConnect_api.repository.UsuarioRepository;
import com.suicide.codeConnect_api.service.UsuarioService;
import com.suicide.codeConnect_api.web.dto.*;
import com.suicide.codeConnect_api.web.dto.mapper.LoginMapper;
import com.suicide.codeConnect_api.web.dto.mapper.UsuarioMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> getById(@PathVariable Long id){
        Usuario user =usuarioService.buscarPorId(id);
        return ResponseEntity.ok(UsuarioMapper.toDto(user));
    }

    @GetMapping("/nome/{name}")
    public ResponseEntity<UsuarioResponseDto> getNome(@PathVariable String name){
        Usuario user = usuarioService.buscarPorNome(name);
        return ResponseEntity.ok(UsuarioMapper.toDto(user));
    }

    @PatchMapping("/atualiza-dados/{id}")
    public ResponseEntity<UsuarioResponseDto> atualizarDados(@PathVariable Long id, @Valid @RequestBody UsuarioUpdateDTO dto){
        Usuario usuario = usuarioService.atualizarDados(id, dto);
        return ResponseEntity.ok(UsuarioMapper.toDto(usuario));
    }

//    @PostMapping("/login")
//    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginDto loginDto){
//        Usuario usuario = usuarioService.autenticar(loginDto.getEmail(), loginDto.getPassword());
//        return ResponseEntity.ok(LoginMapper.toLoginDto(usuario));
//    }

    @PatchMapping("/atualiza-senha/{id}")
        public ResponseEntity<UsuarioResponseDto> updatePassword(@PathVariable Long id, @Valid @RequestBody UsuarioSenhaDto dto){
           Usuario user = usuarioService.editarSenha(id, dto.getSenhaAtual(), dto.getNovaSenha(), dto.getConfirmaSenha());
            return ResponseEntity.ok(UsuarioMapper.toDto(user));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDto>> listar(){
        List<Usuario> user = usuarioService.listarTodos();
        return ResponseEntity.ok(UsuarioMapper.toListDto(user));
    }
    //proximos passos tratar excções e documentar no swagger
}
