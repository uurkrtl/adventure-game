package org.eagle.entites.concretes.weapons;

import org.eagle.entites.abstracts.supportives.Supportive;
import org.eagle.entites.abstracts.supportives.Weapon;

public class Gun extends Weapon {
    public Gun() {
        this.setId(1);
        this.setName("Gun");
        this.setPower(2);
        this.setMoney(25);
    }
}