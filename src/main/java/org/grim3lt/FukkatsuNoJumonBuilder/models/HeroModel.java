package org.grim3lt.FukkatsuNoJumonBuilder.models;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.grim3lt.FukkatsuNoJumonBuilder.values.*;

@Builder
@Getter
@Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class HeroModel {
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
    private final boolean isEquippedDragonScale = false;

    @Builder.Default
    private final boolean isEquippedSolderRing = false;

    @Builder.Default
    private final boolean isEquippedCursedBelt = false;

    @Builder.Default
    private final boolean hasDeathNecklace = false;

    @Builder.Default
    private final boolean beatDragon = false;

    @Builder.Default
    private final boolean beatGolem = false;
}
