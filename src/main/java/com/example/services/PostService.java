package com.example.services;

import com.example.entities.Post;
import com.example.payload.PostDTO;
import com.example.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public PostDTO save(PostDTO postDTO){
        Post post = new Post();
        post.setContent(postDTO.getContent());
        post.setDescription(postDTO.getDescription());
        post.setTitle(postDTO.getTitle());
        Post newPost = postRepository.save(post);

        PostDTO dto = new PostDTO();
        dto.setPostId(newPost.getPostId());
        dto.setContent(newPost.getContent());
        dto.setTitle(newPost.getTitle());
        dto.setDescription(newPost.getDescription());
        return dto;
    }
}
