package com.kmHompage.idolboard.controller;

import com.kmHompage.idolboard.domain.Forum;
import com.kmHompage.idolboard.service.ForumService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@WebFluxTest(HomeController.class)
public class HomeControllerSliceTest {

    @Autowired
    private WebTestClient client;

    @MockBean
    ForumService forumService;

    @Test
    void homepage(){
        when(forumService.getForums()).thenReturn(Flux.just(
                new Forum( "Blackpink", "YG Entertainment's girl group"),
                new Forum( "twice", "JYP Entertainment's girl group")
        ));

        client.get().uri("/").exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .consumeWith(exchangeResult -> {
                    assertThat(
                            exchangeResult.getResponseBody()).contains("td>Blackpink");
                });
    }


    @Test
    void deleteForum(){
        Mono<Void> voidReturn = Mono.empty();
        Mockito.when(forumService.deleteForum("1"))
                .thenReturn(voidReturn);

        client.delete().uri("/delete/{id}", "1").exchange()
                .expectStatus().is3xxRedirection();

    }
}
