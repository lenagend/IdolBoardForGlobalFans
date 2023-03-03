package com.kmHompage.idolboard.settings;

import com.kmHompage.idolboard.domain.Board;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;

public class TemplateDatabaseLoader {
    @Bean
    CommandLineRunner initialize(MongoOperations mongo) {
        return args -> {
            mongo.save(new Board("board1", "Blackpink", "YG Entertainment's girl group"));
            mongo.save(new Board("board2", "twice", "JYP Entertainment's girl group"));
        };
    }
}
