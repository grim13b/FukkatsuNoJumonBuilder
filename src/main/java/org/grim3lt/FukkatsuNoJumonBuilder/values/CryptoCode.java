package org.grim3lt.FukkatsuNoJumonBuilder.values;

public record CryptoCode(int value) {
    public CryptoCode(int value) {
        this.value = Math.min(value, 7);
    }
}
