package org.grim3lt.FukkatsuNoJumonBuilder.values;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public interface IntegerCodeEnum <E extends Enum<E>> {
    Integer getCode();
    String getName();

    static <E extends Enum<E>> List<ItemCode> toList(Class<? extends IntegerCodeEnum<E>> clazz) {
        return Arrays.stream(clazz.getEnumConstants())
                .sorted(Comparator.comparing(IntegerCodeEnum::getCode))
                .map(ice -> new ItemCode(ice.toString(), ice.getName()))
                .collect(Collectors.toList());
    }
}
