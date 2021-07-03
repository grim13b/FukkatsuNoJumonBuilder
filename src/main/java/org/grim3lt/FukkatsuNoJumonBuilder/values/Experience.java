package org.grim3lt.FukkatsuNoJumonBuilder.values;

public record Experience(int value) {
    public Experience(int value) {
        this.value = Math.min(value, 65535);
    }
}
