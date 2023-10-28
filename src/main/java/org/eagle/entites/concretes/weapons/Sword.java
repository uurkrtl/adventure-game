package org.eagle.entites.concretes.weapons;

import org.eagle.entites.abstracts.supportives.Supportive;
import org.eagle.entites.abstracts.supportives.Weapon;

public class Sword extends Weapon {
    public Sword() {
        this.setId(2);
        this.setName("Sword");
        this.setPower(3);
        this.setMoney(35);
    }
}