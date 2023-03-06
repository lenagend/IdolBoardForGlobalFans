package com.kmHompage.idolboard.controller;

import com.kmHompage.idolboard.domain.Post;
import com.kmHompage.idolboard.service.ForumService;
import com.kmHompage.idolboard.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.reactive.result.view.Rendering;
import reactor.core.publisher.Mono;

@Controller
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/post/{id}")
    Mono<Rendering> readPost(@PathVariable String id) {
        return Mono.just(Rendering.view("post.html")
                .modelAttribute("posts",
                this.postService.getPosts(id).doOnNext(System.out::println))
                        .modelAttribute("forumId", id)
                .build());
    }

    @PostMapping("/post/add")
    Mono<String> createPost(@ModelAttribute Post post){
        String uri = "/post/" + post.getForumId();
        return this.postService.savePost(post)
                .thenReturn("redirect:" + uri);
    }

}
