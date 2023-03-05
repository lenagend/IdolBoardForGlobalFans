package com.kmHompage.idolboard.controller;

import com.kmHompage.idolboard.service.ForumService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.result.view.Rendering;
import reactor.core.publisher.Mono;

@Controller
public class PostController {

    private ForumService forumService;

    public PostController(ForumService forumService) {
        this.forumService = forumService;
    }

    @GetMapping("/post/{id}")
    Mono<Rendering> readPost(@PathVariable String id) {
        return Mono.just(Rendering.view("post.html")
                .modelAttribute("posts",
                this.forumService.getPosts(id).doOnNext(System.out::println))
                .build());
    }
}
