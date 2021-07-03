package org.grim3lt.FukkatsuNoJumonBuilder.values;

import lombok.Value;

@Value
public class Herb {
    int value;
    public Herb(int value) {
        this.value = Math.min(value, 7);
    }
}
