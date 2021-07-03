package org.grim3lt.FukkatsuNoJumonBuilder.controllers;

import lombok.AllArgsConstructor;
import org.grim3lt.FukkatsuNoJumonBuilder.models.HeroModel;
import org.grim3lt.FukkatsuNoJumonBuilder.models.JumonModel;
import org.grim3lt.FukkatsuNoJumonBuilder.models.ResponseModel;
import org.grim3lt.FukkatsuNoJumonBuilder.services.JumonService;
import org.grim3lt.FukkatsuNoJumonBuilder.values.Experience;
import org.grim3lt.FukkatsuNoJumonBuilder.values.Gold;
import org.grim3lt.FukkatsuNoJumonBuilder.values.Name;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/")
public class JumonController {
    private final JumonService jumonService;

    @PostMapping("hero")
    public HeroModel hero(String name, int exp, int gold) {
        return HeroModel.builder()
                .name(new Name(name))
                .experience(new Experience(exp))
                .gold(new Gold(gold))
                .build();
    }

    @PostMapping("king")
    public ResponseModel jumon(@RequestBody HeroModel heroModel) {
        // TODO: JacksonがDefaultConstructorを必須で求めるので@Value側で対応が必要
        // https://stackoverflow.com/questions/39381474/cant-make-jackson-and-lombok-work-together

        // modelがnullのときは新しく作る
        String jumon = jumonService.encrypt(heroModel);

        // responseはmodel+jumonのresponse専用modelにする

        return ResponseModel.builder()
                .hero(heroModel)
                .jumon(JumonModel.builder().jumon(jumon).build())
                .build();
    }
}
