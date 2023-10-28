package org.eagle.entites.concretes.battelLocations;

import org.eagle.entites.abstracts.locations.BattelLoc;
import org.eagle.entites.concretes.obstacles.Vampire;
import org.eagle.entites.concretes.obstacles.Zombie;

public class Forest extends BattelLoc {
    public Forest(){
        this.setId(2);
        this.setName("Forest");
        this.setObstacle(new Vampire());
        this.setMoney(0);
        this.setAward("Firewood");
    }
}
