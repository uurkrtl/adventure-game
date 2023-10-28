package org.eagle.entites.abstracts.characters;

import org.eagle.entites.abstracts.supportives.Armor;
import org.eagle.entites.abstracts.supportives.Supportive;
import org.eagle.entites.abstracts.supportives.Weapon;

import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    private int id;
    private String name;
    private String type;
    private int damage;
    private int health;
    private int money;
    private Armor armor;
    private Weapon weapon;

    public Character(int id, String name, int damage, int health, int money, Armor armor, Weapon weapon, String type) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.money = money;
        this.type = type;
    }

    public Character() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public String getType() {return type;}

    public void setType(String type) {this.type = type;}
}
