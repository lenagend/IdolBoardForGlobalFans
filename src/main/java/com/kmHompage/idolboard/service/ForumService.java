package com.kmHompage.idolboard.service;

import com.kmHompage.idolboard.domain.Board;
import com.kmHompage.idolboard.repository.BoardRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ForumService {

    private BoardRepository boardRepository;

    public ForumService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Flux<Board> getForums(){return this.boardRepository.findAll();}

}