package com.kmHompage.idolboard.repository;

import com.kmHompage.idolboard.domain.Board;
import com.kmHompage.idolboard.domain.Post;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface PostRepository extends ReactiveCrudRepository<Board, String > {
    Flux<Post> findByBoardId(String boardId);
}
