package org.grim3lt.FukkatsuNoJumonBuilder.libs;

import org.grim3lt.FukkatsuNoJumonBuilder.models.HeroParameterInput;
import org.grim3lt.FukkatsuNoJumonBuilder.values.Experience;
import org.grim3lt.FukkatsuNoJumonBuilder.values.Gold;
import org.grim3lt.FukkatsuNoJumonBuilder.values.Name;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FukkatsuNoJumonTest {
    @Test
    void encode() {
        HeroParameterInput heroModel = HeroParameterInput.builder()
                .name(new Name("ななし"))
                .gold(new Gold(3321))
                .experience(new Experience(7890))
                .build();
        var jumon = new FukkatsuNoJumon().encode(heroModel);

        assertThat(jumon).hasSize(23);
    }
}