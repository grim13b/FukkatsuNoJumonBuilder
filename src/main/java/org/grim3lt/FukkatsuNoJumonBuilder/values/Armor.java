package org.grim3lt.FukkatsuNoJumonBuilder.values;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Armor implements IntegerCodeEnum {
    NOTHING (0, "なし"),
    CLOTHES (1, "ぬののふく"),
    LEATHER_CLOTHES (3, "かわのふく"),
    CHAIN_MAIL (4, "くさりかたびら"),
    IRON_ARMOR (5, "てつのよろい"),
    FULL_PLATE (6, "はがねのよろい"),
    MAGICAL_ARMOR (6, "まほうのよろい"),
    ARMOR_OF_ROTO (7, "ロトのよろい");

    private final Integer code;
    private final String displayName;

    @Override
    public String toString() {
        return displayName;
    }
}
