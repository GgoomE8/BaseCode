package com.week.one.api.post.controller;

import com.week.one.api.post.dto.PostReqDTO;
import com.week.one.api.post.dto.PostResDTO;
import com.week.one.api.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("")
    public List<PostResDTO> getPostList() {
        return postService.getPostList();
    }
    @GetMapping("/{id}")
    public PostResDTO getPost(@PathVariable long id) {
        return postService.getPost(id);
    }
    @PostMapping("")
    public PostResDTO writePost(@RequestBody PostReqDTO postReqDTO) {
        return postService.writePost(postReqDTO);
    }
    @PutMapping("/{id}")
    public PostResDTO changePost(@PathVariable long id, @RequestBody PostReqDTO postReqDTO) {
        return postService.changePost(id, postReqDTO);
    }
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deletePost(@PathVariable long id, @RequestParam(required = true) String password) {
        return postService.deletePost(id,password);
    }
}
