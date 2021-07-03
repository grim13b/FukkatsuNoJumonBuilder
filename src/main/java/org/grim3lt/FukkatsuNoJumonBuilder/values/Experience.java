package org.grim3lt.FukkatsuNoJumonBuilder.values;

import lombok.Value;

@Value
public class Experience {
    int value;
    public Experience(int value) {
        this.value = Math.min(value, 65535);
    }
}
