package org.grim3lt.FukkatsuNoJumonBuilder.values;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class CryptoCodeTest {
    @Test
    void testValue() {
        assertThat(new CryptoCode(0).value())
                .isEqualTo(0);
        assertThat(new CryptoCode(7).value())
                .isEqualTo(7);
        assertThat(new CryptoCode(10).value())
                .isEqualTo(7);
    }
}