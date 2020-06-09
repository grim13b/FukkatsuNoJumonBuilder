package org.grim3lt.FukkatsuNoJumonBuilder.values;

import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
public class Herb {
    public Herb(int value) {
        this.value = Math.min(value, 7);
    }
    private final int value;
}
