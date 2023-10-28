package org.eagle.entites.concretes.normalLocations;

import org.eagle.entites.abstracts.locations.NormalLoc;

public class ToolStore extends NormalLoc {
    public ToolStore(){
        this.setId(2);
        this.setName("Tool Store");
        this.setFeature("You can buy weapons and armor");
    }
}