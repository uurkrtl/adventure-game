package org.eagle.entites.concretes.players;

import org.eagle.entites.abstracts.characters.Player;

public class Archer extends Player {
    public Archer(String name) {
        this.setId(2);
        this.setDamage(7);
        this.setHealth(18);
        this.setMoney(20);
        this.setName(name);
        this.setType("Archer");
        this.setOriginalHealth(18);
        this.setArmorPower(0);
    }
}