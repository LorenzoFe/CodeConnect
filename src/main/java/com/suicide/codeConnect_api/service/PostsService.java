package com.suicide.codeConnect_api.service;

import com.suicide.codeConnect_api.entity.Posts;
import com.suicide.codeConnect_api.entity.Usuario;
import com.suicide.codeConnect_api.repository.PostsRepository;
import com.suicide.codeConnect_api.repository.UsuarioRepository;
import com.suicide.codeConnect_api.web.dto.PostsDto;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostsService {
    private final PostsRepository postsRepository;
    private final UsuarioService usuarioService;
    private final UsuarioRepository usuarioRepository;

    @Transactional
    public Posts criarPost(PostsDto postsDto) {
        Usuario usuario = usuarioRepository.findById(postsDto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        Posts posts = new Posts();
        posts.setTitle(postsDto.getTitle());
        posts.setDescricaoPost((postsDto.getDescricaoPost()));
        posts.setUsuarioFk(usuario);

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
