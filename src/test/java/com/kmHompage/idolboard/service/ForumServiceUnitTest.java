package com.kmHompage.idolboard.service;

import com.kmHompage.idolboard.domain.Board;
import com.kmHompage.idolboard.repository.BoardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
public class ForumServiceUnitTest {
    ForumService forumService;

    @MockBean private BoardRepository boardRepository;

    @BeforeEach
    void setup(){
        Board sampleBoard = new Board( "Blackpink", "Yg Entertainment's girl group");
        Board sampleBoard2 = new Board("twice", "JYP Entertainment's girl group");
    }


}
