package com.kmHompage.idolboard.domain;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class Comment {
    private @Id String id;
    private String postId;
    private String contents;

    public Comment() {
    }

    public Comment(String id, String postId, String contents) {
        this.id = id;
        this.postId = postId;
        this.contents = contents;
    }

    public Comment(String postId, String contents) {
        this.postId = postId;
        this.contents = contents;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(id, comment.id) && Objects.equals(postId, comment.postId) && Objects.equals(contents, comment.contents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, postId, contents);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", postId='" + postId + '\'' +
                ", contents='" + contents + '\'' +
                '}';
    }
}
