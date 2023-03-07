package com.kmHompage.idolboard.service;

import com.kmHompage.idolboard.domain.Comment;
import com.kmHompage.idolboard.repository.CommentRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Flux<Comment> getComments(String postId){return this.commentRepository.findAllByPostId(postId);}
}
