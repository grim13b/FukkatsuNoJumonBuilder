package org.grim3lt.FukkatsuNoJumonBuilder.services;

import org.grim3lt.FukkatsuNoJumonBuilder.models.HeroModel;
import org.grim3lt.FukkatsuNoJumonBuilder.values.Experience;
import org.grim3lt.FukkatsuNoJumonBuilder.values.Gold;
import org.grim3lt.FukkatsuNoJumonBuilder.values.Name;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class JumonServiceTest {
    @Autowired
    private JumonService jumonService;

    @Test
    void encode() {
        HeroModel heroModel = HeroModel.builder()
                .name(new Name("ななし"))
                .gold(new Gold(3321))
                .experience(new Experience(7890))
                .build();
        var jumon = jumonService.encrypt(heroModel);
    }
}