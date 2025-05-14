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

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostsService {
    private final PostsRepository postsRepository;
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
    public List<Posts> getAllPosts(){
        return postsRepository.findAll();
    }

    @Transactional
    public List<Posts> getPostsByUsuarioId(Long usuarioId){
        var usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(()-> new RuntimeException("Usuário não encontrado"));
        return postsRepository.findByUsuarioFk(usuario);
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
    public List<Posts> buscarPorTitle(String title) {
        return postsRepository.findByTitleContainingIgnoreCase(title);
    }


}
