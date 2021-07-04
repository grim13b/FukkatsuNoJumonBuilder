package org.grim3lt.FukkatsuNoJumonBuilder.values;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GoldTest {
    @Test
    void testValue() {
        assertThat(new Gold(0).value())
                .isEqualTo(0);
        assertThat(new Gold(65535).value())
                .isEqualTo(65535);
        assertThat(new Gold(65536).value())
                .isEqualTo(65535);
        assertThat(new Gold(111_111_111).value())
                .isEqualTo(65535);
    }
}