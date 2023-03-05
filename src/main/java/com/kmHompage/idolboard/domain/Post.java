package com.kmHompage.idolboard.domain;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class Post {
    private @Id
    String id;
    String forumId;
    private String title;
    private String contents;

    public Post(String id, String forumId, String title, String contents) {
        this.id = id;
        this.forumId = forumId;
        this.title = title;
        this.contents = contents;
    }

    public Post(String forumId, String title, String contents) {
        this.forumId = forumId;
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

    public String getForumId() {
        return forumId;
    }

    public void setForumId(String forumId) {
        this.forumId = forumId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) && Objects.equals(forumId, post.forumId) && Objects.equals(title, post.title) && Objects.equals(contents, post.contents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, forumId, title, contents);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", forumId='" + forumId + '\'' +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                '}';
    }
}
