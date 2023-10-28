package org.eagle.business.concretes;

import org.eagle.business.abstracts.PlayerService;
import org.eagle.entites.abstracts.characters.Player;
import org.eagle.entites.abstracts.locations.BattelLoc;
import org.eagle.entites.abstracts.locations.NormalLoc;
import org.eagle.entites.abstracts.supportives.Armor;
import org.eagle.entites.abstracts.supportives.Supportive;
import org.eagle.entites.abstracts.supportives.Weapon;
import org.eagle.entites.concretes.armors.Heavy;
import org.eagle.entites.concretes.armors.Medium;
import org.eagle.entites.concretes.armors.Mild;
import org.eagle.entites.concretes.battelLocations.Cave;
import org.eagle.entites.concretes.battelLocations.Forest;
import org.eagle.entites.concretes.battelLocations.River;
import org.eagle.entites.concretes.normalLocations.SafeHouse;
import org.eagle.entites.concretes.normalLocations.ToolStore;
import org.eagle.entites.concretes.players.Archer;
import org.eagle.entites.concretes.players.Knight;
import org.eagle.entites.concretes.players.Samurai;
import org.eagle.entites.concretes.weapons.Gun;
import org.eagle.entites.concretes.weapons.Rifle;
import org.eagle.entites.concretes.weapons.Sword;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class PlayerManager implements PlayerService {
    Scanner scanner = new Scanner(System.in);
    @Override
    public boolean runLevels(Player player) throws InterruptedException {
        boolean isWin=true;
        BattelLoc[] battelLocs = new BattelLoc[]{new Cave(), new Forest(), new River()};
        for (BattelLoc battelLocation : battelLocs){
            System.out.printf("Level-%d: %s%n",battelLocation.getId(),battelLocation.getName());
            TimeUnit.SECONDS.sleep(2);
            System.out.printf("Level Monster: %s - Power: %d - Health: %d - Money: %d%n",battelLocation.getObstacle().getName(),battelLocation.getObstacle().getDamage(),battelLocation.getObstacle().getHealth(),battelLocation.getObstacle().getMoney());
            isWin = this.attack(player, battelLocation);

            if (!isWin) return isWin;

            if (battelLocation.getId()!= Arrays.stream(battelLocs).count()) this.goNormalLocation(player);
        }
        return isWin;
    }

    @Override
    public void goNormalLocation(Player player) throws InterruptedException {
        NormalLoc[] normalLocs = new NormalLoc[]{new SafeHouse(), new ToolStore()};
        Weapon[] weapons = new Weapon[]{new Gun(), new Sword(),new Rifle()};
        Armor[] armors = new Armor[]{new Mild(),new Medium(),new Heavy()};
        int selectedNormalLocNo = 0;
        int selectedSupportiveNo = 0;
        int selectedWeaponNo = -1;
        int selectedArmorNo = -1;
        Weapon selectedWeapon = null;
        Armor selectedArmor = null;
        boolean haveBudget=false;
        while (!(selectedNormalLocNo>0 && selectedNormalLocNo<= Arrays.stream(normalLocs).count())){
            System.out.printf("Your health: %d - Power: %d - Money: %d%n",player.getHealth(),player.getDamage(),player.getMoney());
            System.out.println("Where do you want to go? Write location number...");
            for (NormalLoc normalLoc : normalLocs){
                System.out.printf("%d: %s (%s)%n",normalLoc.getId(),normalLoc.getName(),normalLoc.getFeature());
            }
            try {
                selectedNormalLocNo=scanner.nextInt();
            }catch (Exception ex){
                System.out.println("You made the wrong choice");
                System.out.println("The computer made the selection: Safe House");
                selectedNormalLocNo = 1;
                break;
            }
        }

        if (selectedNormalLocNo==1){
            player.setHealth(player.getOriginalHealth());
            System.out.println("Your health is full in the safe house. You are going to the next level");
            TimeUnit.SECONDS.sleep(2);
        }else {
            while (!(selectedSupportiveNo>0 && selectedSupportiveNo<=2)){
                System.out.println("What do you want to buy? Your money: " + player.getMoney());
                System.out.println("1: Weapon");
                System.out.println("2: Armor");
                try {
                    selectedSupportiveNo = scanner.nextInt();
                }catch (Exception ex){
                    System.out.println("You made the wrong choice");
                    System.out.println("The computer made the selection: Weapon");
                    selectedSupportiveNo = 1;
                }
            }
            if (selectedSupportiveNo==1){
                while (!(selectedWeaponNo>=0 && selectedWeaponNo<= Arrays.stream(weapons).count())){
                    System.out.println("Which weapon would you like to buy? Your money: " + player.getMoney());
                    for (Weapon weapon : weapons){
                        System.out.printf("%d: %s (Price: %d - Power: %d)%n",weapon.getId(),weapon.getName(), weapon.getMoney(),weapon.getPower());
                    }
                    System.out.println("0: Go to safe house");
                    try {
                        selectedWeaponNo = scanner.nextInt();
                    }catch (Exception ex){
                        System.out.println("You made the wrong choice");
                        System.out.println("You're going to the safe house");
                        selectedWeaponNo=0;
                    }
                }


                if (selectedWeaponNo == 0){
                    player.setHealth(player.getOriginalHealth());
                    System.out.println("Your health is full in the safe house. You are going to the next level");
                    TimeUnit.SECONDS.sleep(2);
                }else {
                    for (Weapon weapon : weapons){
                        if (selectedWeaponNo == weapon.getId()){
                            selectedWeapon=weapon;
                            break;
                        }
                    }
                    if (player.getMoney()>=selectedWeapon.getMoney()){
                        haveBudget=true;
                        player.setDamage(player.getDamage()+selectedWeapon.getPower());
                        player.setMoney(player.getMoney()-selectedWeapon.getMoney());
                    }else {
                        System.out.println("You didn't have enough money");
                        System.out.println("You're going to the safe house");
                        TimeUnit.SECONDS.sleep(2);
                        player.setHealth(player.getOriginalHealth());
                        System.out.println("Your health is full in the safe house. You are going to the next level");
                        TimeUnit.SECONDS.sleep(2);
                    }
                }
            }else {
                //Armor code start

                while (!(selectedArmorNo>=0 && selectedArmorNo<= Arrays.stream(armors).count())){
                    System.out.println("Which armor would you like to buy? Your money: " + player.getMoney());
                    for (Armor armor : armors){
                        System.out.printf("%d: %s (Price: %d - Power: %d)%n",armor.getId(),armor.getName(), armor.getMoney(),armor.getPower());
                    }
                    System.out.println("0: Go to safe house");
                    try {
                        selectedArmorNo = scanner.nextInt();
                    }catch (Exception ex){
                        System.out.println("You made the wrong choice");
                        System.out.println("You're going to the safe house");
                        selectedArmorNo=0;
                    }
                }


                if (selectedArmorNo == 0){
                    player.setHealth(player.getOriginalHealth());
                    System.out.println("Your health is full in the safe house. You are going to the next level");
                    TimeUnit.SECONDS.sleep(2);
                }else {
                    for (Armor armor : armors){
                        if (selectedArmorNo == armor.getId()){
                            selectedArmor=armor;
                            break;
                        }
                    }
                    if (player.getMoney()>=selectedArmor.getMoney()){
                        haveBudget=true;
                        player.setArmorPower(player.getArmorPower()+selectedArmor.getPower());
                        player.setMoney(player.getMoney()-selectedArmor.getMoney());
                    }else {
                        System.out.println("You didn't have enough money");
                        System.out.println("You're going to the safe house");
                        TimeUnit.SECONDS.sleep(2);
                        player.setHealth(player.getOriginalHealth());
                        System.out.println("Your health is full in the safe house. You are going to the next level");
                        TimeUnit.SECONDS.sleep(2);
                    }
                }

                //Armor code end
            }
        }
    }

    @Override
    public boolean attack(Player player, BattelLoc battelLoc) throws InterruptedException {
        boolean isWin=false;
        int obstacleHealth = battelLoc.getObstacle().getHealth();
        int obstacleDamage = 0;
        int earnedMoney = 0;
        if (player.getArmorPower()>=battelLoc.getObstacle().getDamage()){
            obstacleDamage = 0;
        }else {
            obstacleDamage = battelLoc.getObstacle().getDamage()-player.getArmorPower();
        }
        int playerHealth = player.getHealth();
        int playerDamage = player.getDamage();
        int obstacleCount = (int)(Math.random()*3)+1;
        System.out.printf("You will fight %d monsters in this level.%n",obstacleCount);
        TimeUnit.SECONDS.sleep(2);
        String result="";

        while (playerHealth>0 && (obstacleHealth>0 || obstacleCount>0)){
            System.out.println("You are attacking. Health of the beast: " + obstacleHealth);
            TimeUnit.SECONDS.sleep(2);
            if (obstacleHealth-player.getDamage()>0){
                obstacleHealth-=playerDamage;
                System.out.printf("You dealt %d damage. Health of the beast: %d%n",playerDamage,obstacleHealth);
                TimeUnit.SECONDS.sleep(2);
            }else{
                if (obstacleCount>1){
                    obstacleCount--;
                    obstacleHealth = battelLoc.getObstacle().getHealth();
                    System.out.printf("The monster is dead. You won %d money%n",battelLoc.getObstacle().getMoney());
                    System.out.printf("%d monsters left%n",obstacleCount);
                    earnedMoney+=battelLoc.getObstacle().getMoney();
                    TimeUnit.SECONDS.sleep(2);
                }else {
                    obstacleHealth = 0;
                    earnedMoney+=battelLoc.getObstacle().getMoney();
                    player.setMoney(player.getMoney() + earnedMoney);
                    System.out.printf("You have completed the level.%nWhat did you win:%n*Money: %d%n*Award: %s%n",earnedMoney,battelLoc.getAward());
                    earnedMoney = 0;
                    TimeUnit.SECONDS.sleep(2);
                    isWin = true;
                    break;
                }
            }
            System.out.println("Monster is attacking: Your health: " + playerHealth);
            TimeUnit.SECONDS.sleep(2);
            if (playerHealth-obstacleDamage>0 && obstacleHealth!=0){
                playerHealth-= obstacleDamage;
                System.out.printf("Monster dealt %d damage. Your health: %d%n",obstacleDamage,playerHealth);
                TimeUnit.SECONDS.sleep(2);
            }else {
                playerHealth = 0;
                System.out.printf("**Game Over**%nYou died%nHealth of the beast: %d%n",obstacleHealth);
                TimeUnit.SECONDS.sleep(2);
                isWin=false;
                break;
            }
            player.setHealth(playerHealth);
        }
        return isWin;
    }

    @Override
    public String newGame() throws InterruptedException {
        PlayerService playerService = new PlayerManager();

        //Scanner scanner = new Scanner(System.in);
        System.out.println("***New Game***");
        System.out.println("Write your player name...");
        String playerName = scanner.nextLine();

        int selectedPlayerId = 0;
        Player[]players = new Player[]{new Samurai(playerName), new Archer(playerName),new Knight(playerName)};
        Player selectedPlayer=null;

        while(!(selectedPlayerId>0 && selectedPlayerId<= Arrays.stream(players).count())){
            System.out.println("Write player number");
            for (Player player : players){
                System.out.printf("%d: %s (Power: %d - Health: %d - Money: %d) %n",player.getId(),player.getType(),player.getDamage(),player.getHealth(),player.getMoney());
            }
            try {
                selectedPlayerId = scanner.nextInt();
            }catch (Exception ex){
                System.out.println("You made the wrong choice");
                System.out.println("The computer made the selection: Samurai");
                selectedPlayerId = 1;
                break;
            }
        }
        //scanner.close();

        for (Player player : players){
            if (player.getId()==selectedPlayerId) selectedPlayer=player;
        }

        System.out.println("Game starting...");
        TimeUnit.SECONDS.sleep(2);
        boolean isWin = playerService.runLevels(selectedPlayer);
        String result = "Try again";
        if (isWin){
            result="*** Congratulations *** YOU WON ***";
        }
        return result;
    }
}