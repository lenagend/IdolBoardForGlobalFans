package com.kmHompage.idolboard.controller;

import com.kmHompage.idolboard.domain.Post;
import com.kmHompage.idolboard.service.ForumService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@WebFluxTest(PostController.class)
public class PostControllerSliceTest {

    @Autowired
    private WebTestClient client;

    @MockBean
    ForumService forumService;

    @Test
    void postpage(){
        when(forumService.getPosts(anyString())).thenReturn(Flux.just(
                new Post("post1", "1", "blackpink is...", "fantastic"),
                new Post("post2", "1", "blackpink is...2", "good"),
               new Post("post3", "1", "blackpink is...3", "cool")
        ));

        client.get().uri("/post/1").exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .consumeWith(exchangeResult -> {
                    assertThat(exchangeResult.getResponseBody()).contains("blackpink is");
                    assertThat(exchangeResult.getResponseBody()).contains("good");
                });


    }
}
