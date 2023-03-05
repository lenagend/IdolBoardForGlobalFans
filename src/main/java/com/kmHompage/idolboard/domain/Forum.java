package com.kmHompage.idolboard.domain;

import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.Objects;

public class Forum {
    private Board board;
    private List<Post> posts;

    public Forum() {
    }

    public Forum(Board board, List<Post> posts) {
        this.board = board;
        this.posts = posts;
    }

    public Forum(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Forum forum = (Forum) o;
        return Objects.equals(board, forum.board) && Objects.equals(posts, forum.posts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(board, posts);
    }

    @Override
    public String toString() {
        return "Forum{" +
                "board=" + board +
                ", posts=" + posts +
                '}';
    }
}
