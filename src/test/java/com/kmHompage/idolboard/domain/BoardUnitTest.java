package com.kmHompage.idolboard.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class BoardUnitTest {

    @Test
    void BoardBasicsShouldWork(){
        Board sampleBoard = new Board("board1", "Blackpink", "Yg Entertainment's girl group");

        assertThat(sampleBoard.getId()).isEqualTo("board1");
        assertThat(sampleBoard.getName()).isEqualTo("Blackpink");
        assertThat(sampleBoard.getDescription()).isEqualTo("Yg Entertainment's girl group");

        assertThat(sampleBoard.toString()).isEqualTo(
                "Board{id='board1', name='Blackpink', description='Yg Entertainment's girl group'}"
        );

        Board sampleBoard2 = new Board("board1", "Blackpink", "Yg Entertainment's girl group");
        assertThat(sampleBoard).isEqualTo(sampleBoard2);
    }
}
