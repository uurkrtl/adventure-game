package org.eagle.entites.concretes.armors;

import org.eagle.entites.abstracts.supportives.Armor;
import org.eagle.entites.abstracts.supportives.Supportive;

public class Medium extends Armor {
    public Medium(){
        this.setId(2);
        this.setName("Medium");
        this.setPower(3);
        this.setMoney(25);
    }
}
