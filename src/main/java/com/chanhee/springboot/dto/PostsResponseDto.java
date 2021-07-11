package com.chanhee.springboot.dto;

import com.chanhee.springboot.domain.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {

    private Long id;

    private String title;

    private String content;

    private String author;

    public PostsResponseDto(Posts posts) {
        this.id = posts.getId();
        this.title = posts.getTitle();
        this.content = posts.getContent();
        this.author = posts.getAuthor();
    }
}
