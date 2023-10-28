package org.eagle.business.abstracts;

import org.eagle.entites.abstracts.characters.Player;
import org.eagle.entites.abstracts.locations.BattelLoc;

public interface PlayerService {
    public boolean attack(Player player, BattelLoc battelLoc) throws InterruptedException;
    public String newGame() throws InterruptedException;
    public boolean runLevels(Player player) throws InterruptedException;
    public void goNormalLocation(Player player) throws InterruptedException;
}
