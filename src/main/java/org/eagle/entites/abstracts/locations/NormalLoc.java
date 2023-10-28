package org.eagle.entites.abstracts.locations;

public abstract class NormalLoc extends Location {
    private String feature;

    public NormalLoc(String feature) {
        this.feature = feature;
    }

    public NormalLoc() {
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }
}
