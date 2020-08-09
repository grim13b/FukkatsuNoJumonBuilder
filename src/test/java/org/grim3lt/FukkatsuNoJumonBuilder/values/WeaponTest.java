package org.grim3lt.FukkatsuNoJumonBuilder.values;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class WeaponTest {
    @Test
    void displayName() {
        assertThat(Weapon.NOTHING.displayName()).isEqualTo("なし");
        assertThat(Weapon.BAMBOO_LANCE.displayName()).isEqualTo("たけざお");
        assertThat(Weapon.CLUB.displayName()).isEqualTo("こんぼう");
        assertThat(Weapon.COPPER_SWORD.displayName()).isEqualTo("どうのつるぎ");
        assertThat(Weapon.IRON_AXE.displayName()).isEqualTo("てつのおの");
        assertThat(Weapon.IRON_SWORD.displayName()).isEqualTo("はがねのつるぎ");
        assertThat(Weapon.FIRE_SWORD.displayName()).isEqualTo("ほのおのつるぎ");
        assertThat(Weapon.SWORD_OF_ROTO.displayName()).isEqualTo("ロトのつるぎ");
    }

    @Test
    void code() {
        assertThat(Weapon.NOTHING.code()).isEqualTo(0);
        assertThat(Weapon.BAMBOO_LANCE.code()).isEqualTo(1);
        assertThat(Weapon.CLUB.code()).isEqualTo(2);
        assertThat(Weapon.COPPER_SWORD.code()).isEqualTo(3);
        assertThat(Weapon.IRON_AXE.code()).isEqualTo(4);
        assertThat(Weapon.IRON_SWORD.code()).isEqualTo(5);
        assertThat(Weapon.FIRE_SWORD.code()).isEqualTo(6);
        assertThat(Weapon.SWORD_OF_ROTO.code()).isEqualTo(7);
    }
}