package org.grim3lt.FukkatsuNoJumonBuilder.values;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {
    @Test
    void displayName() {
        assertThat(Weapon.NOTHING.getName()).isEqualTo("なし");
        assertThat(Weapon.BAMBOO_LANCE.getName()).isEqualTo("たけざお");
        assertThat(Weapon.CLUB.getName()).isEqualTo("こんぼう");
        assertThat(Weapon.COPPER_SWORD.getName()).isEqualTo("どうのつるぎ");
        assertThat(Weapon.IRON_AXE.getName()).isEqualTo("てつのおの");
        assertThat(Weapon.IRON_SWORD.getName()).isEqualTo("はがねのつるぎ");
        assertThat(Weapon.FIRE_SWORD.getName()).isEqualTo("ほのおのつるぎ");
        assertThat(Weapon.SWORD_OF_ROTO.getName()).isEqualTo("ロトのつるぎ");
    }

    @Test
    void code() {
        assertThat(Weapon.NOTHING.getCode()).isEqualTo(0);
        assertThat(Weapon.BAMBOO_LANCE.getCode()).isEqualTo(1);
        assertThat(Weapon.CLUB.getCode()).isEqualTo(2);
        assertThat(Weapon.COPPER_SWORD.getCode()).isEqualTo(3);
        assertThat(Weapon.IRON_AXE.getCode()).isEqualTo(4);
        assertThat(Weapon.IRON_SWORD.getCode()).isEqualTo(5);
        assertThat(Weapon.FIRE_SWORD.getCode()).isEqualTo(6);
        assertThat(Weapon.SWORD_OF_ROTO.getCode()).isEqualTo(7);
    }
}