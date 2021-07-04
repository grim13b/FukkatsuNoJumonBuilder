package org.grim3lt.FukkatsuNoJumonBuilder.values;

public record Herb(int value) {
    public Herb(int value) {
        this.value = Math.min(value, 7);
    }
}
