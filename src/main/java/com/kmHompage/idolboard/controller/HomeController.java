package com.kmHompage.idolboard.controller;

import com.kmHompage.idolboard.domain.Board;
import com.kmHompage.idolboard.service.ForumService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.result.view.Rendering;
import reactor.core.publisher.Mono;

@Controller
public class HomeController {

    private ForumService forumService;

    public HomeController(ForumService forumService) {
        this.forumService = forumService;
    }

    @GetMapping("/{id}")
    Mono<Rendering> home(@PathVariable(required = false) String id){
        return Mono.just(Rendering.view("home.html")
                        .modelAttribute("forums",
                                this.forumService.getForums(id)
                                        .doOnNext(System.out::println))
                .build());
    }

    @PostMapping("/addBoard")
    Mono<String> createForum(@ModelAttribute Board board){
        return this.forumService.saveBoard(board)
                .thenReturn("redirect:/");
    }

    @DeleteMapping("/delete/{id}")
    Mono<String> deleteForum(@PathVariable String id){
        return this.forumService.deleteBoard(id)
                .thenReturn("redirect:/");
    }
}
