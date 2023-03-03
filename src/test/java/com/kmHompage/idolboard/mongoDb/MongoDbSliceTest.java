package com.kmHompage.idolboard.mongoDb;

import com.kmHompage.idolboard.domain.Board;
import com.kmHompage.idolboard.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import reactor.test.StepVerifier;

import static org.assertj.core.api.Assertions.assertThat;
@DataMongoTest
public class MongoDbSliceTest {

    @Autowired
    BoardRepository repository;

    @Test
    void boardRepositorySavesBoards() {
        Board sampleBoard = new Board("Blackpink", "Yg Entertainment's girl group");

        repository.save(sampleBoard)
                .as(StepVerifier::create)
                .expectNextMatches(board -> {
                    assertThat(board.getId()).isNotNull();
                    assertThat(board.getName()).isEqualTo("Blackpink");
                    assertThat(board.getDescription()).isEqualTo("Yg Entertainment's girl group");

                    return true;
                })
                .verifyComplete();
    }
}
