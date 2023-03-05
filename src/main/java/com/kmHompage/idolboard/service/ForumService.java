package com.kmHompage.idolboard.service;

import com.kmHompage.idolboard.domain.Board;
import com.kmHompage.idolboard.domain.Post;
import com.kmHompage.idolboard.repository.BoardRepository;
import com.kmHompage.idolboard.repository.PostRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ForumService {

    private BoardRepository boardRepository;
    private PostRepository postRepository;

    public ForumService(BoardRepository boardRepository, PostRepository postRepository) {
        this.boardRepository = boardRepository;
        this.postRepository = postRepository;
    }

    public Flux<Board> getForums(){return this.boardRepository.findAll();}
    public Mono<Board> saveForum(Board board){return this.boardRepository.save(board);}
    public Mono<Void> deleteForum(String id){return this.boardRepository.deleteById(id);}

    public Flux<Post> getPosts(String boardId){return this.postRepository.findByBoardId(boardId);}
}
