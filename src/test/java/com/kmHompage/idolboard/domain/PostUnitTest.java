package com.kmHompage.idolboard.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PostUnitTest {
    @Test
    void postBasicsShouldWork(){
        Post samplePost = new Post("post1","board1", "title1", "contents1");

        assertThat(samplePost.getId()).isEqualTo("post1");
        assertThat(samplePost.getBoardId()).isEqualTo("board1");
        assertThat(samplePost.getTitle()).isEqualTo("title1");
        assertThat(samplePost.getContents()).isEqualTo("contents1");

        assertThat(samplePost.toString()).isEqualTo(
                "Post{id='post1', boardId='board1', title='title1', contents='contents1'}"
        );

        Post samplePost2 = new Post("post1","board1", "title1", "contents1");
        assertThat(samplePost).isEqualTo(samplePost2);

    }
}