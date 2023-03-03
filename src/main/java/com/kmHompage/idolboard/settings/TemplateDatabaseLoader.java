package com.kmHompage.idolboard.settings;

import com.kmHompage.idolboard.domain.Board;
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
            mongo.save(new Board("Blackpink", "YG Entertainment's girl group"));
            mongo.save(new Board( "twice", "JYP Entertainment's girl group"));
        };
    }
}
