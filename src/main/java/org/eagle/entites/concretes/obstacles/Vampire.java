package org.eagle.entites.concretes.obstacles;

import org.eagle.entites.abstracts.characters.Obstacle;

public class Vampire extends Obstacle {
    public Vampire(){
        this.setId(2);
        this.setDamage(4);
        this.setHealth(14);
        this.setMoney(7);
        this.setName("Vampire");
    }
}
