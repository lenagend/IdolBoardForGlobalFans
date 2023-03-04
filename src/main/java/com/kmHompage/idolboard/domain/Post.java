package com.kmHompage.idolboard.domain;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class Post {
    private @Id
    String id;
    String boardId;
    private String title;
    private String contents;

    public Post(String id, String boardId, String title, String contents) {
        this.id = id;
        this.boardId = boardId;
        this.title = title;
        this.contents = contents;
    }

    public Post(String boardId, String title, String contents) {
        this.boardId = boardId;
        this.title = title;
        this.contents = contents;
    }

    public Post() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getBoardId() {
        return boardId;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) && Objects.equals(boardId, post.boardId) && Objects.equals(title, post.title) && Objects.equals(contents, post.contents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, boardId, title, contents);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", boardId='" + boardId + '\'' +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                '}';
    }
}
