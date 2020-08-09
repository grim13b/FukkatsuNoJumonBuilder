package org.grim3lt.FukkatsuNoJumonBuilder.values;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class ArmorTest {
    @Test
    void testDisplayName() {
        assertThat(Armor.NOTHING.displayName()).isEqualTo("なし");
        assertThat(Armor.CLOTHES.displayName()).isEqualTo("ぬののふく");
        assertThat(Armor.ARMOR_OF_ROTO.displayName()).isEqualTo("ロトのよろい");
    }

    @Test
    void testCode() {
        assertThat(Armor.CHAIN_MAIL.code()).isEqualTo(3);
        assertThat(Armor.FULL_PLATE.code()).isEqualTo(5);
        assertThat(Armor.MAGICAL_ARMOR.code()).isEqualTo(6);
    }
}