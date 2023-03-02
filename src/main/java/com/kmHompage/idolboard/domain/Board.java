package com.kmHompage.idolboard.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class Board {
    private @Id
    String id;
    private String name;
    private String description;
}
