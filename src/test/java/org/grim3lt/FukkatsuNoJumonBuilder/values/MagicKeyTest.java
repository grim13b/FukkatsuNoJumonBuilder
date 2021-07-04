package org.grim3lt.FukkatsuNoJumonBuilder.values;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MagicKeyTest {
    @Test
    void testValue() {
        assertThat(new MagicKey(0).value())
                .isEqualTo(0);
        assertThat(new MagicKey(7).value())
                .isEqualTo(7);
        assertThat(new MagicKey(10).value())
                .isEqualTo(7);
    }
}