package org.grim3lt.FukkatsuNoJumonBuilder.controllers;

import org.grim3lt.FukkatsuNoJumonBuilder.values.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {

    @GetMapping("weapons")
    public List<ItemCode> getWeapons() {
        return IntegerCodeEnum.toList(Weapon.class);
    }

    @GetMapping("armors")
    public List<ItemCode> getArmors() {
        return IntegerCodeEnum.toList(Armor.class);
    }

    @GetMapping("shields")
    public List<ItemCode> getShields() {
        return IntegerCodeEnum.toList(Shield.class);
    }

    @GetMapping("items")
    public List<ItemCode> getItems() {
        return IntegerCodeEnum.toList(Item.class);
    }
}
