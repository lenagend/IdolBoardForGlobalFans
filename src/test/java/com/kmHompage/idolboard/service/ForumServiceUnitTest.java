package com.kmHompage.idolboard.service;

import com.kmHompage.idolboard.domain.Board;
import com.kmHompage.idolboard.domain.Post;
import com.kmHompage.idolboard.repository.BoardRepository;
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

    @MockBean private BoardRepository boardRepository;

    @MockBean private PostRepository postRepository;

    @BeforeEach
    void setup(){
        Board sampleBoard = new Board( "Blackpink", "Yg Entertainment's girl group");
        Board sampleBoard2 = new Board("twice", "JYP Entertainment's girl group");

        Post samplePost = new Post("board1", "title1", "content1");

        when(boardRepository.save(any(Board.class))).thenReturn(Mono.just(sampleBoard));
        when(postRepository.findByBoardId(anyString())).thenReturn(Flux.just(samplePost));

        forumService = new ForumService(boardRepository, postRepository);
    }

    @Test
    void addForumTest(){
        forumService.saveForum(new Board( "Blackpink", "Yg Entertainment's girl group"))
                .as(StepVerifier::create)
                .expectNextMatches(board -> {
                    assertThat(board.getName()).isEqualTo("Blackpink");
                    return true;
                }).verifyComplete();

    }

    @Test
    void deleteForumTest(){
        Mono<Void> voidReturn = Mono.empty();
        Mockito.when(forumService.deleteForum("1"))
                .thenReturn(voidReturn);

    }

    @Test
    void getPostsTest(){
        forumService.getPosts("board1")
                .as(StepVerifier::create)
                .expectNextMatches(post ->{
                    assertThat(post.getTitle()).isEqualTo("title1");
                    return true;
                }).verifyComplete();
    }


}
