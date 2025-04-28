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
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/Posts")
public class PostsController {

    private final PostsService PostsService;
    private final PostsRepository PostsRepository;

    @PostMapping
    public ResponseEntity<PostsDto> create(@Valid @RequestBody PostsDto createDto){
        Posts post = PostsService.criarPost(PosteMapper.toPoste(createDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(PosteMapper.toDto(post));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostsDto> getById(@PathVariable Long id){
        Posts post =PostsService.buscarPorId(id);
        return ResponseEntity.ok(PosteMapper.toDto(post));
    }

    @PostMapping("/titulo")
    public ResponseEntity<PostsDto> getTitle(@RequestBody TitleDto title){
        Posts post = PostsService.buscarPorTitle(title.getTitle());
        return ResponseEntity.ok(PosteMapper.toDto(post));
    }

    @PostMapping("/tag")
    public ResponseEntity<PostsDto> getTag(@RequestBody TagDto tag){
        Posts post = PostsService.buscarPorTag(tag.getTag());
        return ResponseEntity.ok(PosteMapper.toDto(post));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostsDto> update(@PathVariable Long id, @Valid @RequestBody PostsDto dto) {
        Posts postAtualizado = PostsService.atualizarPost(id, PosteMapper.toPoste(dto));
        return ResponseEntity.ok(PosteMapper.toDto(postAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        PostsService.deletarPost(id);
        return ResponseEntity.noContent().build();
    }

}
