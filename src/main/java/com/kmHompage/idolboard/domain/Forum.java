package com.kmHompage.idolboard.domain;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class Forum {
    private @Id
    String id;
    private String name;
    private String description;


    public Forum() {
    }

    public Forum(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Forum(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Forum board = (Forum) o;
        return Objects.equals(id, board.id) && Objects.equals(name, board.name) && Objects.equals(description, board.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }

    @Override
    public String toString() {
        return "Board{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

