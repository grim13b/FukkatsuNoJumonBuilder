package org.grim3lt.FukkatsuNoJumonBuilder.values;

import lombok.ToString;

import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ToString
public class Name {
    private final String value;

    public Name(String value) {
        this.value = Stream.of(value.split(""))
                .map (c -> DakutenMap.getOrDefault(c, c))
                .collect(Collectors.joining())
                .substring(0, Math.min(value.length(), 4));
    }

    private final HashMap<String, String> DakutenMap = new HashMap<>() {
        {
            put("が", "か゛");
            put("ぎ", "き゛");
            put("ぐ", "く゛");
            put("げ", "け゛");
            put("ご", "こ゛");
            put("ざ", "さ゛");
            put("じ", "し゛");
            put("ず", "す゛");
            put("ぜ", "せ゛");
            put("ぞ", "そ゛");
            put("だ", "た゛");
            put("ぢ", "ち゛");
            put("づ", "つ゛");
            put("で", "て゛");
            put("ど", "と゛");
            put("ば", "は゛");
            put("び", "ひ゛");
            put("ぶ", "ふ゛");
            put("べ", "へ゛");
            put("ぼ", "ほ゛");
            put("ぱ", "は゜");
            put("ぴ", "ひ゜");
            put("ぷ", "ふ゜");
            put("ぺ", "へ゜");
            put("ぽ", "ほ゜");
        }
    };
}
