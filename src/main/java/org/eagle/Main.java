package org.eagle;

import org.eagle.business.abstracts.PlayerService;
import org.eagle.business.concretes.PlayerManager;
import org.eagle.entites.abstracts.characters.Player;
import org.eagle.entites.abstracts.locations.BattelLoc;
import org.eagle.entites.concretes.battelLocations.Cave;
import org.eagle.entites.concretes.battelLocations.Forest;
import org.eagle.entites.concretes.obstacles.Vampire;
import org.eagle.entites.concretes.players.Archer;
import org.eagle.entites.concretes.players.Knight;
import org.eagle.entites.concretes.players.Samurai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        PlayerManager playerManager = new PlayerManager();
        System.out.println(playerManager.newGame()); ;
    }
}