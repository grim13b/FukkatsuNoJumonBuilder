package org.grim3lt.FukkatsuNoJumonBuilder.controllers;

import org.grim3lt.FukkatsuNoJumonBuilder.libs.FukkatsuNoJumon;
import org.grim3lt.FukkatsuNoJumonBuilder.models.HeroInput;
import org.grim3lt.FukkatsuNoJumonBuilder.models.HeroParameterInput;
import org.grim3lt.FukkatsuNoJumonBuilder.models.JumonOutput;
import org.grim3lt.FukkatsuNoJumonBuilder.values.Experience;
import org.grim3lt.FukkatsuNoJumonBuilder.values.Gold;
import org.grim3lt.FukkatsuNoJumonBuilder.values.Name;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class JumonController {
    @PostMapping("hero")
    public HeroParameterInput hero(@RequestBody HeroInput input) {
        return HeroParameterInput.builder()
                .name(new Name(input.name()))
                .experience(new Experience(input.experience()))
                .gold(new Gold(input.gold()))
                .build();
    }

    @PostMapping("king")
    public JumonOutput jumon(@RequestBody HeroParameterInput input) {
        String jumon = new FukkatsuNoJumon().encode(input);
        return new JumonOutput(jumon);
    }
}
