package com.example.controller;

import com.example.entities.Post;
import com.example.payload.PostDTO;
import com.example.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;

    //localhost:8080/api/posts
    @PostMapping
    public ResponseEntity<PostDTO> savePost(@RequestBody PostDTO postDTO){
        PostDTO dto = postService.save(postDTO);
        return  new ResponseEntity(dto, HttpStatus.CREATED);
    }
}
