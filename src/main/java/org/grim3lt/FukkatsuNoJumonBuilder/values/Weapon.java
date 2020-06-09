package org.grim3lt.FukkatsuNoJumonBuilder.values;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Getter
@Accessors(fluent = true)
public enum Weapon implements IntegerCodeEnum {
    NOTHING (0, "なし"),
    BAMBOO_LANCE (1, "たけざお"),
    CLUB (2, "こんぼう"),
    COPPER_SWORD (3, "どうのつるぎ"),
    IRON_AXE (4, "てつのおの"),
    IRON_SWORD (5, "はがねのつるぎ"),
    FIRE_SWORD (6, "ほのおのつるぎ"),
    SWORD_OF_ROTO (7, "ロトのつるぎ");

    private final Integer code;
    private final String displayName;

    @Override
    public String toString() {
        return displayName;
    }
}
