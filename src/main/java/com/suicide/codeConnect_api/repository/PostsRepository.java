package com.suicide.codeConnect_api.repository;

import com.suicide.codeConnect_api.entity.Posts;
import com.suicide.codeConnect_api.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostsRepository extends JpaRepository<Posts,Long> {
    Optional<Posts> findByTitle(String title);
    List<Posts> findByUsuarioFk(Usuario usuario);
}
