package com.kmHompage.idolboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.result.view.Rendering;
import reactor.core.publisher.Mono;

@Controller
public class HomeController {

    @GetMapping
    Mono<Rendering> home(){
        return Mono.just(Rendering.view("home.html")
                .build());
    }
}
