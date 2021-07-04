package org.grim3lt.FukkatsuNoJumonBuilder.values;

public record Gold(int value) {
    public Gold(int value) {
        this.value = Math.min(value, 65535);
    }
}
