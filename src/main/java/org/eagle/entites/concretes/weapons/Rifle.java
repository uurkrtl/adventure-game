package org.eagle.entites.concretes.weapons;

import org.eagle.entites.abstracts.supportives.Supportive;
import org.eagle.entites.abstracts.supportives.Weapon;

public class Rifle extends Weapon {
    public Rifle(){
        this.setId(3);
        this.setName("Rifle");
        this.setPower(7);
        this.setMoney(45);
    }
}
