package com.kmHompage.idolboard.repository;

import com.kmHompage.idolboard.domain.Comment;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface CommentRepository extends ReactiveCrudRepository<Comment, String> {
    Flux<Comment> findAllByPostId(String postId);
}
