package org.grim3lt.FukkatsuNoJumonBuilder.models;


import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.grim3lt.FukkatsuNoJumonBuilder.values.*;

@Builder
@Getter
public class HeroParameterInput {
    @Builder.Default
    private final Name name = new Name("ななし");

    @Builder.Default
    private final Experience experience = new Experience(0);

    @Builder.Default
    private final Gold gold = new Gold(0);

    @Builder.Default
    private final MagicKey magicKey = new MagicKey(0);

    @Builder.Default
    private final Herb herb = new Herb(0);

    @Builder.Default
    private final Item[] items = {
            Item.NOTHING,
            Item.NOTHING,
            Item.NOTHING,
            Item.NOTHING,
            Item.NOTHING,
            Item.NOTHING,
            Item.NOTHING,
            Item.NOTHING
    };

    @Builder.Default
    private final Weapon weapon = Weapon.NOTHING;

    @Builder.Default
    private final Armor armor = Armor.NOTHING;

    @Builder.Default
    private final Shield shield = Shield.NOTHING;

    @Builder.Default
    private final boolean equipped_dragon_scale = false;

    @Builder.Default
    private final boolean equipped_solder_ring = false;

    @Builder.Default
    private final boolean equipped_cursed_belt = false;

    @Builder.Default
    private final boolean equipped_death_necklace = false;

    @Builder.Default
    private final boolean beat_dragon = false;

    @Builder.Default
    private final boolean beat_golem = false;
}
