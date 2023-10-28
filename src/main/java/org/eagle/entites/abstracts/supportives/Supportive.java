package org.eagle.entites.abstracts.supportives;

public abstract class Supportive {
    private int id;
    private String name;
    private int power;
    private int money;

    public Supportive(int id, int power, int money, String name) {
        this.id = id;
        this.power = power;
        this.money = money;
        this.name = name;
    }

    public Supportive() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
