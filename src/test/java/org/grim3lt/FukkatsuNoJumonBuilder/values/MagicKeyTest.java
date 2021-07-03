package org.grim3lt.FukkatsuNoJumonBuilder.values;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class MagicKeyTest {
    @Test
    void testValue() {
        assertThat(new MagicKey(0).getValue())
                .isEqualTo(0);
        assertThat(new MagicKey(7).getValue())
                .isEqualTo(7);
        assertThat(new MagicKey(10).getValue())
                .isEqualTo(7);
    }
}