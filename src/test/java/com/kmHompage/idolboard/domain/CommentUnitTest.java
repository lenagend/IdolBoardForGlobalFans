package com.kmHompage.idolboard.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CommentUnitTest {

    @Test
    void commentBasicsShouldWork(){
        Comment sampleComment = new Comment("comment1", "post1", "youre right");

        assertThat(sampleComment.getId()).isEqualTo("comment1");
        assertThat(sampleComment.getPostId()).isEqualTo("post1");
        assertThat(sampleComment.getContents()).isEqualTo("youre right");

        Comment sampleComment2 = new Comment("comment1", "post1", "youre right");

        assertThat(sampleComment).isEqualTo(sampleComment2);
    }
}
