package com.week.one.api.post.entity;

import com.week.one.api.common.entity.Timestamped;
import com.week.one.api.post.dto.PostReqDTO;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "Posts")
@Table(indexes = @Index(name = "i_post", columnList = "post_id"))
public class Post extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String author;

    public Post(PostReqDTO reqDTO) {
        this.title = reqDTO.getTitle();
        this.content = reqDTO.getContent();
        this.password = reqDTO.getPassword();
        this.author = reqDTO.getAuthor();
    }

    public void update(PostReqDTO reqDTO) {
        this.title = reqDTO.getTitle();
        this.content = reqDTO.getContent();
        this.password = reqDTO.getPassword();
        this.author = reqDTO.getAuthor();
    }
}
