package org.eagle.entites.abstracts.locations;

import org.eagle.entites.abstracts.characters.Obstacle;

public abstract class BattelLoc extends Location {
    private int money;
    private String award;
    private Obstacle obstacle;

    public BattelLoc(int id, String name, int money, String award, Obstacle obstacle) {
        super(id, name);
        this.money = money;
        this.award = award;
        this.obstacle = obstacle;
    }

    public BattelLoc() {
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }
}
