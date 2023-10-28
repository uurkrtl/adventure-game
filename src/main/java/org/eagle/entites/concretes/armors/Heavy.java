package org.eagle.entites.concretes.armors;

import org.eagle.entites.abstracts.supportives.Armor;
import org.eagle.entites.abstracts.supportives.Supportive;

public class Heavy extends Armor {
    public Heavy(){
        this.setId(3);
        this.setName("Heavy");
        this.setPower(5);
        this.setMoney(40);
    }
}