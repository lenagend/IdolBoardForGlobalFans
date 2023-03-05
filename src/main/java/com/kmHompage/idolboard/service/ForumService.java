package com.kmHompage.idolboard.service;

import com.kmHompage.idolboard.domain.Board;
import com.kmHompage.idolboard.domain.Forum;
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

    public Flux<Board> getBoards(){return this.boardRepository.findAll();}
    public Mono<Board> saveBoard(Board board){return this.boardRepository.save(board);}
    public Mono<Void> deleteBoard(String id){return this.boardRepository.deleteById(id);}
    public Flux<Post> getPosts(String boardId){return this.postRepository.findByBoardId(boardId);}
    public Flux<Forum> getForums(String id){
        return this.boardRepository.findAll()
            .defaultIfEmpty(new Board("board1", "Blackpink", "Yg Entertainment's girl group"))
            .map(board -> {
//                if(id.length() > 1)
                return new Forum(board);
            });
    }
}
