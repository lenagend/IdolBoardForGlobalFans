package com.kmHompage.idolboard.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ForumUnitTest {

    @Test
    void BoardBasicsShouldWork(){
        Forum sampleForum = new Forum("forum1", "Blackpink", "Yg Entertainment's girl group");

        assertThat(sampleForum.getId()).isEqualTo("forum1");
        assertThat(sampleForum.getName()).isEqualTo("Blackpink");
        assertThat(sampleForum.getDescription()).isEqualTo("Yg Entertainment's girl group");

        assertThat(sampleForum.toString()).isEqualTo(
                "Board{id='forum1', name='Blackpink', description='Yg Entertainment's girl group'}"
        );

        Forum sampleBoard2 = new Forum("forum1", "Blackpink", "Yg Entertainment's girl group");
        assertThat(sampleForum).isEqualTo(sampleBoard2);
    }
}
