package org.eagle.entites.concretes.normalLocations;

import org.eagle.entites.abstracts.locations.NormalLoc;

public class SafeHouse extends NormalLoc {
    public SafeHouse(){
        this.setId(1);
        this.setName("Safe House");
        this.setFeature("Your health will be full");
    }
}