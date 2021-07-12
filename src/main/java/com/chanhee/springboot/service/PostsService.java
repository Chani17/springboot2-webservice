package com.chanhee.springboot.service;

import com.chanhee.springboot.domain.Posts;
import com.chanhee.springboot.domain.PostsRepository;
import com.chanhee.springboot.dto.PostsListResponseDto;
import com.chanhee.springboot.dto.PostsSaveRequestDto;
import com.chanhee.springboot.dto.PostsResponseDto;
import com.chanhee.springboot.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto postsSaveRequestDto) {
        return postsRepository.save(postsSaveRequestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto postsUpdateRequestDto) {

        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id =" + id));

        posts.update(postsUpdateRequestDto.getTitle(), postsUpdateRequestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {

        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id" + id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id =" + id));
        postsRepository.delete(posts);
    }
}
