package com.kmHompage.idolboard.service;

import com.kmHompage.idolboard.domain.Comment;
import com.kmHompage.idolboard.domain.Post;
import com.kmHompage.idolboard.repository.CommentRepository;
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
public class CommentServiceUnitTest {
    CommentService commentService;

    @MockBean
    private CommentRepository commentRepository;

    @BeforeEach
    void setup() {
        Comment sampleComment = new Comment("comment1", "post1", "contents1");
        Comment sampleComment2 = new Comment("comment2", "post1", "contents2");

        when(commentRepository.findAllByPostId(anyString())).thenReturn(Flux.just(
                sampleComment,
                sampleComment2
        ));
        when(commentRepository.save(any(Comment.class))).thenReturn(Mono.just(
                sampleComment
        ));


        commentService = new CommentService(commentRepository);

    }

    @Test
    void getCommentsTest(){
        commentService.getComments("post1")
                .as(StepVerifier::create)
                .expectNextMatches(comment -> {
                    assertThat(comment.getPostId()).isEqualTo("post1");
                    return true;
                }).expectNextCount(1)
                .expectComplete()
                .verify();
    }

    @Test
    void saveCommentTest(){
        commentService.saveComment(new Comment("comment1", "post1", "contents1"))
                .as(StepVerifier::create)
                .expectNextMatches(comment -> {
                    assertThat(comment.getContents()).isEqualTo("contents1");
                    return true;
                }).verifyComplete();
    }

    @Test
    void deleteCommentTest(){
        Mono<Void> voidReturn = Mono.empty();
        Mockito.when(commentService.deleteComment("1"))
                .thenReturn(voidReturn);
    }
}
