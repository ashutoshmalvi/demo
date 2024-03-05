package com.example.services;

import com.example.entities.Comment;
import com.example.entities.Post;
import com.example.payload.CommentDTO;
import com.example.repository.CommentRepository;
import com.example.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;


    public CommentDTO save(Long postId, CommentDTO commentDTO){
        Post post = postRepository.findById(postId).get();
        Comment comment = new Comment();
        comment.setBody(commentDTO.getBody());
        comment.setEmail(commentDTO.getEmail());
        comment.setName(commentDTO.getName());
        comment.setPost(post);
        Comment newComment = commentRepository.save(comment);

        CommentDTO dto = new CommentDTO();
        dto.setCommentId(newComment.getCommentId());
        dto.setName(newComment.getName());
        dto.setEmail(newComment.getEmail());
        dto.setBody(newComment.getBody());


        return dto;
    }
}
