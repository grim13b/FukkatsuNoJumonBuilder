package org.grim3lt.FukkatsuNoJumonBuilder.values;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class GoldTest {
    @Test
    void testValue() {
        assertThat(new Gold(0).getValue())
                .isEqualTo(0);
        assertThat(new Gold(65535).getValue())
                .isEqualTo(65535);
        assertThat(new Gold(65536).getValue())
                .isEqualTo(65535);
        assertThat(new Gold(111_111_111).getValue())
                .isEqualTo(65535);
    }
}