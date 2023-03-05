package com.kmHompage.idolboard.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ForumUnitTest {
    @Test
    void forumBasicsShouldWork(){
        List<Post> posts = Arrays.asList( new Post("post1","board1", "title1", "contents1"),
                new Post("post2","board1", "title2", "contents2"),
                new Post("post3","board1", "title3", "contents3"));
        Board board = new Board("board1", "Blackpink", "Yg Entertainment's girl group");
        Forum sampleForum = new Forum("forum1", board, posts);

        assertThat(sampleForum.getId()).isEqualTo("forum1");
        assertThat(sampleForum.getBoard()).isEqualTo(board);
        assertThat(sampleForum.getPosts()).isEqualTo(posts);

        assertThat(sampleForum.toString()).isEqualTo(
                "Forum{id='forum1', board=Board{id='board1', name='Blackpink', description='Yg Entertainment's girl group'}, posts=[Post{id='post1', boardId='board1', title='title1', contents='contents1'}, Post{id='post2', boardId='board1', title='title2', contents='contents2'}, Post{id='post3', boardId='board1', title='title3', contents='contents3'}]}"
        );

        Forum sampleForum2 = new Forum("forum1", board, posts);
        assertThat(sampleForum).isEqualTo(sampleForum2);

    }
}
