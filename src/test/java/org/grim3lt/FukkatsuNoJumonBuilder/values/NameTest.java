package org.grim3lt.FukkatsuNoJumonBuilder.values;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class NameTest {
    @Test
    void testLength() {
        assertThat(new Name("あいう").value())
                .hasSize(3)
                .isEqualTo("あいう");

        assertThat(new Name("がらい").value())
                .hasSize(4)
                .isEqualTo("か゛らい");

        assertThat(new Name("がざじ").value())
                .hasSize(4)
                .isEqualTo("か゛さ゛");

        assertThat(new Name("あいうえお").value())
                .hasSize(4)
                .isEqualTo("あいうえ");
    }
}