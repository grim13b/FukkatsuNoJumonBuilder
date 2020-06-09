package org.grim3lt.FukkatsuNoJumonBuilder.values;

import lombok.Getter;

@Getter
public class CryptoCode {
    public CryptoCode(int value) {
        this.value = Math.min(value, 7);
    }
    private final int value;
}
