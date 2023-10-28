package org.eagle.entites.concretes.armors;

import org.eagle.entites.abstracts.supportives.Armor;
import org.eagle.entites.abstracts.supportives.Supportive;

public class Mild extends Armor {
    public Mild(){
        this.setId(1);
        this.setName("Mild");
        this.setPower(1);
        this.setMoney(15);
    }
}
