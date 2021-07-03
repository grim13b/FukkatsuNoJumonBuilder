package org.grim3lt.FukkatsuNoJumonBuilder.models;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ResponseModel {
    private final HeroModel hero;
    private final JumonModel jumon;
}
