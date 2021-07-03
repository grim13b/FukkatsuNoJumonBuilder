package org.grim3lt.FukkatsuNoJumonBuilder.values;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Getter
public enum Item implements IntegerCodeEnum<Item> {
    NOTHING (0, "なし"),
    TOUCH (1, "たいまつ"),
    HOLY_WATER (2, "せいすい"),
    WING (3, "キメラのつばさ"),
    DRAGON_SCALE (4, "りゅうのうろこ"),
    FAIRY_FLUTE (5, "ようせいのふえ"),
    SOLDER_RING (6, "せんしのゆびわ"),
    ROTOS_TOKEN (7, "ロトのしるし"),
    PRINCESS_LOVE (8, "おうじょのあい"),
    CURSE_BELT (9, "のろいのベルト"),
    SILVER_HARP (10, "ぎんのたてごと"),
    DEATH_NECKLACE (11, "しのくびかざり"),
    STONE_OF_SUNLIGHT (12, "たいようのいし"),
    STUFF_OF_THE_RAIN (13, "あまぐものつえ"),
    RAINBOW_DROP (14, "にじのしずく"),
    UNKNOWN (15, "（不明）");

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
