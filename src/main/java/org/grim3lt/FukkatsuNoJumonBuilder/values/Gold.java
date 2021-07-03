package org.grim3lt.FukkatsuNoJumonBuilder.values;

import lombok.Value;

@Value
public class Gold {
    int value;
    public Gold(int value) {
        this.value = Math.min(value, 65535);
    }
}
