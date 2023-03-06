package com.kmHompage.idolboard.service;

import com.kmHompage.idolboard.domain.Forum;
import com.kmHompage.idolboard.domain.Post;
import com.kmHompage.idolboard.repository.ForumRepository;
import com.kmHompage.idolboard.repository.PostRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ForumService {

    private final ForumRepository forumRepository;

    public ForumService(ForumRepository forumRepository) {
        this.forumRepository = forumRepository;
    }

    public Flux<Forum> getForums(){return this.forumRepository.findAll();}
    public Mono<Forum> saveForum(Forum board){return this.forumRepository.save(board);}
    public Mono<Void> deleteForum(String id){return this.forumRepository.deleteById(id);}

}
