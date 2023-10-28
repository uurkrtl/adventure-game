package org.eagle.entites.concretes.obstacles;

import org.eagle.entites.abstracts.characters.Obstacle;

public class Zombie extends Obstacle {
    public Zombie(){
        this.setId(1);
        this.setDamage(3);
        this.setHealth(10);
        this.setMoney(4);
        this.setName("Zombie");
    }
}
