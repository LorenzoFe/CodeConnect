package com.suicide.codeConnect_api.service;

import com.suicide.codeConnect_api.entity.Posts;
import com.suicide.codeConnect_api.entity.Usuario;
import com.suicide.codeConnect_api.repository.PostsRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Posts criarPost(Posts posts) {
        return postsRepository.save(posts);
    }

    @Transactional
    public Posts atualizarPost(Long id, Posts postAtualizado) {
        Posts postExistente = buscarPorId(id);
        postExistente.setTitle(postAtualizado.getTitle());
        postExistente.setDescricaoPost(postAtualizado.getDescricaoPost());
        postExistente.setTag(postAtualizado.getTag());

        return postsRepository.save(postExistente);
    }
    @Transactional
    public void deletarPost(Long id) {
        Posts post = buscarPorId(id);
        postsRepository.delete(post);
    }

    @Transactional
    public Posts buscarPorId(Long id) {
        return postsRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Post não encontrado", id))
        );
    }

    @Transactional
    public Posts buscarPorTitle(String title) {
        return postsRepository.findByTitle(title).orElseThrow(
                () -> new EntityNotFoundException(String.format("titulo não encontrado", title))
        );
    }

    @Transactional
    public Posts buscarPorTag(String tag) {
        return postsRepository.findByTag(tag).orElseThrow(
                () -> new EntityNotFoundException(String.format("tag não encontrada", tag))
        );
    }










}
