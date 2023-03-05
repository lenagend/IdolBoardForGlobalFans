package com.kmHompage.idolboard.settings;

import com.kmHompage.idolboard.domain.Forum;
import com.kmHompage.idolboard.domain.Post;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

@Component
public class TemplateDatabaseLoader {
    @Bean
    CommandLineRunner initialize(MongoOperations mongo) {
        return args -> {
            mongo.save(new Forum( "1", "Blackpink", "YG Entertainment's girl group"));
            mongo.save(new Forum( "2", "twice", "JYP Entertainment's girl group"));
            mongo.save(new Post("post1", "1", "blackpink is...", "fantastic"));
            mongo.save(new Post("post2", "1", "blackpink is...2", "good"));
            mongo.save(new Post("post3", "1", "blackpink is...3", "cool"));
        };
    }
}
