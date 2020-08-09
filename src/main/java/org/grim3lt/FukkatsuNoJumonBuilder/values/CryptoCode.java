package org.grim3lt.FukkatsuNoJumonBuilder.values;

import lombok.Value;
import lombok.experimental.Accessors;

@Value
@Accessors(fluent = true)
public class CryptoCode {
    int value;
    public CryptoCode(int value) {
        this.value = Math.min(value, 7);
    }
}
