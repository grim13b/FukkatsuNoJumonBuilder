package org.grim3lt.FukkatsuNoJumonBuilder.values;

import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
public class Experience {
    public Experience(int value) {
        this.value = Math.min(value, 65535);
    }
    private final int value;
}