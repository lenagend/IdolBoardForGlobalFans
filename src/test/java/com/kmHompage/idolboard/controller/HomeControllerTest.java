package com.kmHompage.idolboard.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;

@WebFluxTest(HomeController.class)
public class HomeControllerTest {

    @Autowired
    private WebTestClient client;

    @Test
    void homepage(){
        client.get().uri("/").exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .consumeWith(exchangeResult -> {
                    assertThat(
                            exchangeResult.getResponseBody()).contains("<h1>Welcome to K-Fans</h1> ");
                });
    }
}
