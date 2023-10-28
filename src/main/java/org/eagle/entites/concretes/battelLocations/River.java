package org.eagle.entites.concretes.battelLocations;

import org.eagle.entites.abstracts.locations.BattelLoc;
import org.eagle.entites.concretes.obstacles.Bear;
import org.eagle.entites.concretes.obstacles.Zombie;

public class River extends BattelLoc {
    public River(){
        this.setId(3);
        this.setName("River");
        this.setObstacle(new Bear());
        this.setMoney(0);
        this.setAward("Water");
    }
}