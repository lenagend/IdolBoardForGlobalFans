package com.kmHompage.idolboard.settings;

import com.kmHompage.idolboard.domain.Board;
import com.kmHompage.idolboard.domain.Post;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

@Component
public class TemplateDatabaseLoader {
    @Bean
    CommandLineRunner initialize(MongoOperations mongo) {
        return args -> {
            mongo.save(new Board( "board1", "Blackpink", "YG Entertainment's girl group"));
            mongo.save(new Board( "board2", "twice", "JYP Entertainment's girl group"));
            mongo.save(new Post("post1", "board1", "blackpink is...", "fantastic"));
            mongo.save(new Post("post2", "board1", "blackpink is...2", "good"));
            mongo.save(new Post("post3", "board1", "blackpink is...3", "cool"));
        };
    }
}
