package org.eagle.entites.concretes.players;

import org.eagle.entites.abstracts.characters.Player;

public class Knight extends Player {
    public Knight(String name) {
        this.setId(3);
        this.setDamage(8);
        this.setHealth(24);
        this.setMoney(5);
        this.setName(name);
        this.setType("Knight");
        this.setOriginalHealth(24);
        this.setArmorPower(0);
    }
}