package com.week.one.api.post.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostReqDTO {
    private String title;
    private String content;
    private String author;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
