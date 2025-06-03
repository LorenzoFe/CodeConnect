package com.suicide.codeConnect_api.web.dto.mapper;

import com.suicide.codeConnect_api.entity.Posts;
import com.suicide.codeConnect_api.web.dto.PostsDto;
import com.suicide.codeConnect_api.web.dto.PostsResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;

import java.util.List;
import java.util.stream.Collectors;

public class PosteMapper {

    private static final ModelMapper modelMapper = new ModelMapper();
    public static Posts toPoste(PostsDto postsDto){
        return modelMapper.map(postsDto, Posts.class);
    }


    public static PostsResponseDTO toDto(Posts posts){
        PostsResponseDTO dto = modelMapper.map(posts, PostsResponseDTO.class);
        if (posts.getUsuarioFk() != null){
            dto.setNomeUsuario(posts.getUsuarioFk().getName());
            dto.setUserId(posts.getUsuarioFk().getId());
        }
        return dto;
    }
    public static List<PostsResponseDTO> toListDto(List<Posts> posts){
        return posts.stream().map(post ->toDto(post)).collect(Collectors.toList());
    }

}
