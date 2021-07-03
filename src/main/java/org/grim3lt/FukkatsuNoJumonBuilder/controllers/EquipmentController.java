package org.grim3lt.FukkatsuNoJumonBuilder.controllers;

import org.grim3lt.FukkatsuNoJumonBuilder.models.KeyValueResponseModel;
import org.grim3lt.FukkatsuNoJumonBuilder.values.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {

    @GetMapping("weapons")
    public List<KeyValueResponseModel> getWeapons() {
        return IntegerCodeEnum.toList(Weapon.class);
    }

    @GetMapping("armors")
    public List<KeyValueResponseModel> getArmors() {
        return IntegerCodeEnum.toList(Armor.class);
    }

    @GetMapping("shields")
    public List<KeyValueResponseModel> getShields() {
        return IntegerCodeEnum.toList(Shield.class);
    }

    @GetMapping("items")
    public List<KeyValueResponseModel> getItems() {
        return IntegerCodeEnum.toList(Item.class);
    }
}
