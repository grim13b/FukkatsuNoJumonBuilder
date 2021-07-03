package org.grim3lt.FukkatsuNoJumonBuilder.services;

import org.grim3lt.FukkatsuNoJumonBuilder.models.HeroModel;
import org.springframework.stereotype.Service;

@Service
public class JumonService {

    public String encrypt(HeroModel heroModel) {
        // TODO: 実装
        return FukkatsuNoJumon.builder()
                .build()
                .encrypt();
    }
}
