package org.grim3lt.FukkatsuNoJumonBuilder.values;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ArmorTest {
    @Test
    void testDisplayName() {
        assertThat(Armor.NOTHING.getName()).isEqualTo("なし");
        assertThat(Armor.CLOTHES.getName()).isEqualTo("ぬののふく");
        assertThat(Armor.ARMOR_OF_ROTO.getName()).isEqualTo("ロトのよろい");
    }

    @Test
    void testCode() {
        assertThat(Armor.CHAIN_MAIL.getCode()).isEqualTo(3);
        assertThat(Armor.FULL_PLATE.getCode()).isEqualTo(5);
        assertThat(Armor.MAGICAL_ARMOR.getCode()).isEqualTo(6);
    }
}