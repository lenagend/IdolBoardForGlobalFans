package com.kmHompage.idolboard.service;

import com.kmHompage.idolboard.domain.Post;
import com.kmHompage.idolboard.repository.PostRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Flux<Post> getPosts(String boardId){return this.postRepository.findByForumId(boardId);}
    public Mono<Post> savePost(Post post){return this.postRepository.save(post);}
    public Mono<Void> deletePost(String id){return this.postRepository.deleteById(id);}
}
