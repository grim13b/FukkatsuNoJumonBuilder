package org.grim3lt.FukkatsuNoJumonBuilder.values;

import org.grim3lt.FukkatsuNoJumonBuilder.models.KeyValueResponseModel;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public interface IntegerCodeEnum <E extends Enum<E>> {
    Integer getCode();
    String getName();

    static <E extends Enum<E>> List<KeyValueResponseModel> toList(Class<? extends IntegerCodeEnum<E>> clazz) {
        return Arrays.stream(clazz.getEnumConstants())
                .sorted(Comparator.comparing(IntegerCodeEnum::getCode))
                .map(ice -> new KeyValueResponseModel(ice.getName(), ice.getCode()))
                .collect(Collectors.toList());
    }

//    static <E extends Enum<E>> List<E> getOrderedList(Class<? extends CodeEnum<E>> clazz) {
//        return Arrays.stream(clazz.getEnumConstants())
//                .sorted(Comparator.comparing(CodeEnum::getOrder))
//                .map(CodeEnum::toEnum)
//                .collect(Collectors.toList());
//    }
}
