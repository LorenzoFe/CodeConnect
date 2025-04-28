package com.suicide.codeConnect_api.repository;

import com.suicide.codeConnect_api.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostsRepository extends JpaRepository<Posts,Long> {
    Optional<Posts> findByTitle(String title);
    Optional<Posts> findByTag(String tag);
}
