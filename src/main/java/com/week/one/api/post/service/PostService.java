package com.week.one.api.post.service;

import com.week.one.api.post.dto.PostReqDTO;
import com.week.one.api.post.dto.PostResDTO;
import com.week.one.api.post.entity.Post;
import com.week.one.api.post.repository.PostRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public List<PostResDTO> getPostList() {
        List<Post> list = postRepository.findAllByOrderByIdDesc();
        return PostResDTO.of(list);
    }

    @Transactional(readOnly = true)
    public PostResDTO getPost(long id) {
        Optional<Post> post = postRepository.findById(id);
        return post.isPresent() ? PostResDTO.of(post.get()) : null;
    }

    @Transactional
    public PostResDTO writePost(PostReqDTO postReqDTO) {
        Post post = postRepository.saveAndFlush(new Post(postReqDTO));
        return PostResDTO.of(post);
    }

    @Transactional
    public PostResDTO changePost(long id, PostReqDTO postReqDTO) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("글이 존재하지 않습니다")
        );
        if(validCheck(post.getPassword(), postReqDTO.getPassword())) {
            post.update(postReqDTO);
            return PostResDTO.of(post);
        } else
           throw new IllegalArgumentException("패스워드가 다릅니다.");
    }

    @Transactional
    public Map<String, Boolean> deletePost(long id, String password) {
        Optional<Post> post = postRepository.findById(id);
        boolean checking = post.isPresent();
        if(checking && validCheck(post.get().getPassword(), password)) {
            postRepository.deleteById(id);
        } else {
            checking = false;
        }
        Map<String, Boolean> check = new HashMap<>();
        check.put("success", checking);
        return check;
    }

    private boolean validCheck(String password, String inputPassword) {
        return password.equals(inputPassword);
    }
}
