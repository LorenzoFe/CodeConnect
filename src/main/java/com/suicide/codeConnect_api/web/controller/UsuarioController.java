package com.suicide.codeConnect_api.web.controller;


import com.suicide.codeConnect_api.entity.Usuario;
import com.suicide.codeConnect_api.repository.UsuarioRepository;
import com.suicide.codeConnect_api.service.UsuarioService;
import com.suicide.codeConnect_api.web.dto.LoginDto;
import com.suicide.codeConnect_api.web.dto.UsuarioCreateDto;
import com.suicide.codeConnect_api.web.dto.UsuarioResponseDto;
import com.suicide.codeConnect_api.web.dto.UsuarioSenhaDto;
import com.suicide.codeConnect_api.web.dto.mapper.UsuarioMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
        Usuario usuario = usuarioService.autenticar(loginDto.getEmail(), loginDto.getPassword());
        return ResponseEntity.ok("Login realizado com sucesso");
    }

    @PatchMapping("/{id}")
        public ResponseEntity<UsuarioResponseDto> updatePassword(@PathVariable Long id, @Valid @RequestBody UsuarioSenhaDto dto){
           Usuario user = usuarioService.editarSenha(id, dto.getSenhaAtual(), dto.getNovaSenha(), dto.getConfirmaSenha());
            return ResponseEntity.ok(UsuarioMapper.toDto(user));
    }
    //proximos passos tratar excções e documentar no swagger
}
