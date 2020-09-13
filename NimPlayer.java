package NimGame;

import java.lang.*;
public class NimPlayer {
    private String playerName;
    private int numOfWin;

    public int getNumOfWin() {
        return numOfWin;
    }
    public NimPlayer(String playerName){
        this.playerName = playerName;
        this.numOfWin = 0;
    }
    public String getPlayerName() {
        return playerName;
    }
    public int removeStone(int stoneRemove){
        return stoneRemove;
    }
    public void gameWin(){
        this.numOfWin+=1;
        System.out.println(this.playerName + " wins!\n");
    }
}


/*
package nim;

import java.util.Scanner;

class Player {

    private Scanner in;
    private String name;

    // If name is in source code.
    Player(String n, Scanner scan) {
        in = scan;
        name = n;
    }

    // If name is determined by the console.
    Player(Scanner scan) {
        in = scan;
        setName();
    }

    // Set name;
    public void setName(String n) {
        name = n;
    }

    // Set name via console.
    public void setName() {
        System.out.print("Enter name: ");
        try {
            if(in.hasNextLine()) {
                name = in.nextLine();
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    // Get name.
    public String getName() {
        return name;
    }
}
*/
