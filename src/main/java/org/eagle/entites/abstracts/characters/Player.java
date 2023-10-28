package org.eagle.entites.abstracts.characters;

public abstract class Player extends Character {
    private int originalHealth;
    private int armorPower;

    public Player(int originalHealth, int armorPower) {

        this.originalHealth = originalHealth;
        this.armorPower = armorPower;
    }

    public Player() {
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }

    public int getArmorPower() {
        return armorPower;
    }

    public void setArmorPower(int armorPower) {
        this.armorPower = armorPower;
    }
}
