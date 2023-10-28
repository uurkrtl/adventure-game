package org.eagle.entites.concretes.players;

import org.eagle.entites.abstracts.characters.Player;

public class Samurai extends Player {
    public Samurai(String name) {
        this.setId(1);
        this.setDamage(5);
        this.setHealth(21);
        this.setMoney(15);
        this.setName(name);
        this.setType("Samurai");
        this.setOriginalHealth(21);
        this.setArmorPower(0);
    }
}