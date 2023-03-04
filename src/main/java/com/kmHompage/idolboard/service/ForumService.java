package com.kmHompage.idolboard.service;

import com.kmHompage.idolboard.domain.Board;
import com.kmHompage.idolboard.repository.BoardRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ForumService {

    private BoardRepository boardRepository;

    public ForumService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Flux<Board> getForums(){return this.boardRepository.findAll();}
    public Mono<Board> saveForum(Board board){return this.boardRepository.save(board);}
    public Mono<Void> deleteForum(String id){return this.boardRepository.deleteById(id);}

}
