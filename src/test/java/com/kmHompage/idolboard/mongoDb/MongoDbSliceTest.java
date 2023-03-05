package com.kmHompage.idolboard.mongoDb;

import com.kmHompage.idolboard.domain.Forum;
import com.kmHompage.idolboard.repository.ForumRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import reactor.test.StepVerifier;

import static org.assertj.core.api.Assertions.assertThat;
@DataMongoTest
public class MongoDbSliceTest {

    @Autowired
    ForumRepository repository;

    @Test
    void boardRepositorySavesBoards() {
        Forum sampleBoard = new Forum("Blackpink", "Yg Entertainment's girl group");

        repository.save(sampleBoard)
                .as(StepVerifier::create)
                .expectNextMatches(forum -> {
                    assertThat(forum.getId()).isNotNull();
                    assertThat(forum.getName()).isEqualTo("Blackpink");
                    assertThat(forum.getDescription()).isEqualTo("Yg Entertainment's girl group");

                    return true;
                })
                .verifyComplete();
    }
}
