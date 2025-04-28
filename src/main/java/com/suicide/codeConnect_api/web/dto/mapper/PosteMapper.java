package com.suicide.codeConnect_api.web.dto.mapper;

import com.suicide.codeConnect_api.entity.Posts;
import com.suicide.codeConnect_api.web.dto.PostsDto;
import org.modelmapper.ModelMapper;

public class PosteMapper {



    public static Posts toPoste(PostsDto postsDto){
        return new ModelMapper().map(postsDto, Posts.class);
    }


    public static PostsDto toDto(Posts posts){
        return new ModelMapper().map(posts, PostsDto.class);
    }
}
