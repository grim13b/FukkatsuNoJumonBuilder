package org.grim3lt.FukkatsuNoJumonBuilder.values;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ShieldTest {
    @Test
    void displayName() {
        assertThat(Shield.NOTHING.getName()).isEqualTo("なし");
        assertThat(Shield.LEATHER_SHIELD.getName()).isEqualTo("かわのたて");
        assertThat(Shield.SILVER_SHIELD.getName()).isEqualTo("みかがみのたて");
    }

    @Test
    void code() {
        assertThat(Shield.NOTHING.getCode()).isEqualTo(0);
        assertThat(Shield.LEATHER_SHIELD.getCode()).isEqualTo(1);
        assertThat(Shield.SILVER_SHIELD.getCode()).isEqualTo(3);
    }
}