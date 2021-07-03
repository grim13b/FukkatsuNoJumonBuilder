package org.grim3lt.FukkatsuNoJumonBuilder.values;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Armor implements IntegerCodeEnum<Armor> {
    NOTHING (0, "なし"),
    CLOTHES (1, "ぬののふく"),
    LEATHER_CLOTHES (2, "かわのふく"),
    CHAIN_MAIL (3, "くさりかたびら"),
    IRON_ARMOR (4, "てつのよろい"),
    FULL_PLATE (5, "はがねのよろい"),
    MAGICAL_ARMOR (6, "まほうのよろい"),
    ARMOR_OF_ROTO (7, "ロトのよろい");

    private final Integer code;
    private final String name;

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getName() {
        return name;
    }
}
