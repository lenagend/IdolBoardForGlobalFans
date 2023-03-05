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

    private ForumRepository forumRepository;
    private PostRepository postRepository;

    public ForumService(ForumRepository forumRepository, PostRepository postRepository) {
        this.forumRepository = forumRepository;
        this.postRepository = postRepository;
    }

    public Flux<Forum> getForums(){return this.forumRepository.findAll();}
    public Mono<Forum> saveForum(Forum board){return this.forumRepository.save(board);}
    public Mono<Void> deleteForum(String id){return this.forumRepository.deleteById(id);}
    public Flux<Post> getPosts(String boardId){return this.postRepository.findByForumId(boardId);}

}
