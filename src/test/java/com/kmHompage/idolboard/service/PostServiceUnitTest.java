package com.kmHompage.idolboard.service;

import com.kmHompage.idolboard.domain.Forum;
import com.kmHompage.idolboard.domain.Post;
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
public class PostServiceUnitTest {

    PostService postService;

    @MockBean
    private PostRepository postRepository;

    @BeforeEach
    void setup() {
        Post samplePost = new Post("board1", "title1", "content1");

        when(postRepository.findByForumId(anyString())).thenReturn(Flux.just(samplePost));
        when(postRepository.findById(anyString())).thenReturn(Mono.just(samplePost));
        when(postRepository.save(any(Post.class))).thenReturn(Mono.just(samplePost));

        postService = new PostService(postRepository);

    }

    @Test
    void getPostsTest() {
        postService.getPosts("forum1")
                .as(StepVerifier::create)
                .expectNextMatches(post -> {
                    assertThat(post.getTitle()).isEqualTo("title1");
                    return true;
                }).verifyComplete();
    }

    @Test
    void getPost() {
        postService.getPosts("post1")
                .as(StepVerifier::create)
                .expectNextMatches(post -> {
                    assertThat(post.getTitle()).isEqualTo("title1");
                    return true;
                }).verifyComplete();
    }

    @Test
    void createPostTest(){
        postService.savePost(new Post("board1", "title1", "content1"))
                .as(StepVerifier::create)
                .expectNextMatches(post -> {
                    assertThat(post.getTitle()).isEqualTo("title1");
                    return true;
                }).verifyComplete();
    }

    @Test
    void deletePostTest(){
        Mono<Void> voidReturn = Mono.empty();
        Mockito.when(postService.deletePost("1"))
                .thenReturn(voidReturn);
    }
}
