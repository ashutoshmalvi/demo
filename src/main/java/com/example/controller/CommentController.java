package com.example.controller;

import com.example.entities.Comment;
import com.example.payload.CommentDTO;
import com.example.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts/")
public class CommentController {

    @Autowired
    private CommentService commentService;
    //http://localhost:8080/api/posts/1/comments
    @PostMapping("{postId}/comments")
    public ResponseEntity<CommentDTO> saveComment(@PathVariable Long postId, @RequestBody CommentDTO commentDTO){
    CommentDTO dto = commentService.save(postId, commentDTO);
    return ResponseEntity.ok(dto);
}

}
