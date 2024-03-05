package com.example.payload;

import com.example.entities.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
    private Long commentId;
    private String body;
    private String email;
    private String name;

}
