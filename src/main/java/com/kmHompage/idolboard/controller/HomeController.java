package com.kmHompage.idolboard.controller;

import com.kmHompage.idolboard.service.ForumService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.result.view.Rendering;
import reactor.core.publisher.Mono;

@Controller
public class HomeController {

    private ForumService forumService;

    public HomeController(ForumService forumService) {
        this.forumService = forumService;
    }

    @GetMapping
    Mono<Rendering> home(){
        return Mono.just(Rendering.view("home.html")
                        .modelAttribute("forums",
                                this.forumService.getForums()
                                        .doOnNext(System.out::println))
                .build());
    }
}
