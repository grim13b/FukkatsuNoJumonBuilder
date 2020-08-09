package org.grim3lt.FukkatsuNoJumonBuilder.values;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class ShieldTest {
    @Test
    void displayName() {
        assertThat(Shield.NOTHING.displayName()).isEqualTo("なし");
        assertThat(Shield.LEATHER_SHIELD.displayName()).isEqualTo("かわのたて");
        assertThat(Shield.SILVER_SHIELD.displayName()).isEqualTo("みかがみのたて");
    }

    @Test
    void code() {
        assertThat(Shield.NOTHING.code()).isEqualTo(0);
        assertThat(Shield.LEATHER_SHIELD.code()).isEqualTo(1);
        assertThat(Shield.SILVER_SHIELD.code()).isEqualTo(3);
    }
}