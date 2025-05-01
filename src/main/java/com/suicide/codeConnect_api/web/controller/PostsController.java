package com.suicide.codeConnect_api.web.controller;


import com.suicide.codeConnect_api.entity.Posts;
import com.suicide.codeConnect_api.repository.PostsRepository;
import com.suicide.codeConnect_api.service.PostsService;
import com.suicide.codeConnect_api.web.dto.*;
import com.suicide.codeConnect_api.web.dto.mapper.PosteMapper;
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
@RequestMapping("api/v1/Posts")
public class PostsController {

    private final PostsService postsService;

    @PostMapping
    public ResponseEntity<PostsResponseDTO> create(@Valid @RequestBody PostsDto createDto){
        var post = postsService.criarPost(createDto);
        return ResponseEntity.ok(PosteMapper.toDto(post));
    }

    @GetMapping
    public ResponseEntity<List<PostsResponseDTO>> getAllPosts(){
        List<Posts> posts = postsService.getAllPosts();
        return ResponseEntity.ok(PosteMapper.toListDto(posts));
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<PostsResponseDTO>> getPostsByUsuario(@PathVariable Long usuarioId){
        List<Posts> posts = postsService.getPostsByUsuarioId(usuarioId);
        return ResponseEntity.ok(PosteMapper.toListDto(posts));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostsResponseDTO> getById(@PathVariable Long id){
        Posts post = postsService.buscarPorId(id);
        return ResponseEntity.ok(PosteMapper.toDto(post));
    }

    @PostMapping("/titulo")
    public ResponseEntity<PostsResponseDTO> getTitle(@RequestBody TitleDto title){
        Posts post = postsService.buscarPorTitle(title.getTitle());
        return ResponseEntity.ok(PosteMapper.toDto(post));
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<PostsDto> update(@PathVariable Long id, @Valid @RequestBody PostsDto dto) {
//        Posts postAtualizado = postsService.atualizarPost(id, PosteMapper.toPoste(dto));
//        return ResponseEntity.ok(PosteMapper.toDto(postAtualizado));
//    }
//
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        postsService.deletarPost(id);
        return ResponseEntity.noContent().build();
    }

}
