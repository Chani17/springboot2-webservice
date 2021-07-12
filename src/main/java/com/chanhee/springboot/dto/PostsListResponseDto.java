package com.chanhee.springboot.dto;

import com.chanhee.springboot.domain.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsListResponseDto {

    private Long id;

    private String title;

    private String author;

    private LocalDateTime modifiedDate;

    public PostsListResponseDto(Posts posts) {
        this.id = posts.getId();
        this.title = posts.getTitle();
        this.author = posts.getAuthor();
        this.modifiedDate = posts.getUpdateDate();
    }
}
