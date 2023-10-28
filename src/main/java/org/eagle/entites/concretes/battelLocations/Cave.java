package org.eagle.entites.concretes.battelLocations;

import org.eagle.entites.abstracts.locations.BattelLoc;
import org.eagle.entites.concretes.obstacles.Zombie;

public class Cave extends BattelLoc {
    public Cave(){
        this.setId(1);
        this.setName("Cave");
        this.setObstacle(new Zombie());
        this.setMoney(0);
        this.setAward("Food");
    }
}
