package com.kmHompage.idolboard.controller;

import com.kmHompage.idolboard.domain.Comment;
import com.kmHompage.idolboard.domain.Post;
import com.kmHompage.idolboard.service.CommentService;
import com.kmHompage.idolboard.service.ForumService;
import com.kmHompage.idolboard.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.result.view.Rendering;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class PostController {

    private PostService postService;

    private CommentService commentService;

    public PostController(PostService postService, CommentService commentService) {
        this.postService = postService;
        this.commentService = commentService;
    }

    @GetMapping("/post/{forumId}")
    Mono<Rendering> getPosts(@PathVariable String forumId) {
        return Mono.just(Rendering.view("post.html")
                .modelAttribute("posts",
                this.postService.getPosts(forumId).doOnNext(System.out::println))
                        .modelAttribute("forumId", forumId)
                .build());
    }

    @PostMapping("/post/add")
    Mono<String> createPost(@ModelAttribute Post post){
        String uri = "/post/" + post.getForumId();
        return this.postService.savePost(post)
                .thenReturn("redirect:" + uri);
    }

    @DeleteMapping("/post/delete")
    Mono<String> deletePost(@ModelAttribute Post post){
        String uri = "/post/" + post.getForumId();
        return this.postService.deletePost(post.getId())
                .thenReturn("redirect:" + uri);
    }

    @GetMapping("/post/read/{postId}")
    Mono<Rendering> readPost(@PathVariable String postId) {
        return Mono.just(Rendering.view("readPost.html")
                .modelAttribute("comments",
                        this.commentService.getComments(postId).doOnNext(System.out::println))
                .modelAttribute("post",
                        this.postService.getPost(postId).doOnNext(System.out::println))
                .build());
    }

    @PostMapping("/comment/add")
    Mono<String> createComment(@ModelAttribute Comment comment){
        String uri = "/post/read/" + comment.getPostId();
        return this.commentService.saveComment(comment)
                .thenReturn("redirect:" + uri);
    }

    @DeleteMapping("/comment/delete")
    Mono<String> deleteComment(@ModelAttribute Comment comment){
        String uri = "/post/read/" + comment.getPostId();
        return this.commentService.deleteComment(comment.getId())
                .thenReturn("redirect:" + uri);
    }



}
