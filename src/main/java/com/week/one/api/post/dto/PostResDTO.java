package com.week.one.api.post.dto;

import com.week.one.api.post.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostResDTO {
    private long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public static PostResDTO of(Post post) {
        return PostResDTO.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .author(post.getAuthor())
                .createdAt(post.getCreatedAt())
                .modifiedAt(post.getModifiedAt())
                .build();
    }

    public static List<PostResDTO> of(List<Post> posts) {
//        return posts.stream().map(post -> PostResDTO.of(post)).collect(Collectors.toList());
        return posts.stream().map(PostResDTO::of).collect(Collectors.toList());
    }
}
