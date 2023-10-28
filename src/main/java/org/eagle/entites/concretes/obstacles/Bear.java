package org.eagle.entites.concretes.obstacles;

import org.eagle.entites.abstracts.characters.Obstacle;

public class Bear extends Obstacle {
    public Bear() {
        this.setId(3);
        this.setDamage(7);
        this.setHealth(20);
        this.setMoney(12);
        this.setName("Bear");
    }
}