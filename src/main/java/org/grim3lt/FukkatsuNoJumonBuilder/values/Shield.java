package org.grim3lt.FukkatsuNoJumonBuilder.values;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Getter
public enum Shield implements IntegerCodeEnum<Shield> {
    NOTHING (0, "なし"),
    LEATHER_SHIELD (1, "かわのたて"),
    IRON_SHIELD (2, "てつのたて"),
    SILVER_SHIELD (3, "みかがみのたて");

    private final Integer code;
    private final String name;
}

