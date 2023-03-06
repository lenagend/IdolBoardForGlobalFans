package com.kmHompage.idolboard.service;

import com.kmHompage.idolboard.domain.Forum;
import com.kmHompage.idolboard.domain.Post;
import com.kmHompage.idolboard.repository.ForumRepository;
import com.kmHompage.idolboard.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
public class ForumServiceUnitTest {

    ForumService forumService;

    @MockBean
    private ForumRepository forumRepository;



    @BeforeEach
    void setup() {
        Forum sampleBoard = new Forum("Blackpink", "Yg Entertainment's girl group");
        Forum sampleBoard2 = new Forum("twice", "JYP Entertainment's girl group");

        Post samplePost = new Post("board1", "title1", "content1");

        when(forumRepository.save(any(Forum.class))).thenReturn(Mono.just(sampleBoard));
        when(forumRepository.findAll()).thenReturn(Flux.just(sampleBoard));

        forumService = new ForumService(forumRepository);
    }

    @Test
    void addBoardTest() {
        forumService.saveForum(new Forum("Blackpink", "Yg Entertainment's girl group"))
                .as(StepVerifier::create)
                .expectNextMatches(forum -> {
                    assertThat(forum.getName()).isEqualTo("Blackpink");
                    return true;
                }).verifyComplete();

    }

    @Test
    void deleteBoardTest() {
        Mono<Void> voidReturn = Mono.empty();
        Mockito.when(forumService.deleteForum("1"))
                .thenReturn(voidReturn);

    }


    @Test
    void getForumsTest() {
        forumService.getForums()
                .as(StepVerifier::create)
                .expectNextMatches(forum -> {
                    assertThat(forum.getName()).isEqualTo("Blackpink");
                    return true;
                }).verifyComplete();
    }
}