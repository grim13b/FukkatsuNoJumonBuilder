package org.grim3lt.FukkatsuNoJumonBuilder.values;

public record MagicKey(int value) {
    public MagicKey(int value) {
        this.value = Math.min(value, 7);
    }
}
