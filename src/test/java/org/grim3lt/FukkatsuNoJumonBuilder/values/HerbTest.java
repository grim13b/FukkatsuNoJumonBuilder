package org.grim3lt.FukkatsuNoJumonBuilder.values;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HerbTest {
    @Test
    void testValue() {
        assertThat(new Herb(0).getValue())
                .isEqualTo(0);
        assertThat(new Herb(7).getValue())
                .isEqualTo(7);
        assertThat(new Herb(10).getValue())
                .isEqualTo(7);
    }
}