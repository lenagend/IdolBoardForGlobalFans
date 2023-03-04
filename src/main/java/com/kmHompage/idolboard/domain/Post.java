package com.kmHompage.idolboard.domain;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class Post {
    private @Id
    String id;
    private String title;
    private String contents;

    public Post(String id, String title, String contents) {
        this.id = id;
        this.title = title;
        this.contents = contents;
    }

    public Post(String title, String contents) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id.equals(post.id) && title.equals(post.title) && contents.equals(post.contents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, contents);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                '}';
    }
}
