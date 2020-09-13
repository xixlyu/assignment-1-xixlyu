package NimGame;

import java.util.Scanner;
public class NimGame {
    private NimPlayer player1;
    private NimPlayer player2;
    private int upBound;
    private int stoneRemain;
    private int timesOfGame;
    private boolean player1Turn;

    public NimGame(Scanner keyboard) {
        System.out.print("Please enter Player 1's name : ");
        this.player1 = new NimPlayer(keyboard.next());
        System.out.print("Please enter Player 2's name : ");
        this.player2 = new NimPlayer(keyboard.next());
    }
    public void playGame(Scanner keyboard) {
        System.out.print("Enter upper bound : ");
        this.upBound = keyboard.nextInt();
        System.out.print("Enter initial number of stones : ");
        this.stoneRemain = keyboard.nextInt();

        this.player1Turn = true;

        while (this.stoneRemain > 0) {
            printStone();
            if (this.player1Turn == true) {
                playerPick(this.player1, keyboard);
            } else {
                playerPick(this.player2, keyboard);
            }
        }
        System.out.println("\nGAME OVER");
        timesOfGame++;
        if (this.player1Turn == true) {
            this.player1.gameWin();
        } else {
            this.player2.gameWin();
        }
    }
    public void playerPick(NimPlayer player, Scanner keyboard) {
        while(true) {
            System.out.print("\n"+player.getPlayerName() + "'s turn. Enter stones to remove : ");
            int stoneRemove = player.removeStone(keyboard.nextInt());


            if (stoneRemove <= stoneRemain && stoneRemove <= upBound) {
                this.stoneRemain = this.stoneRemain - stoneRemove;
                this.player1Turn = !(this.player1Turn);
                break;
            } else if (stoneRemove > this.upBound) {
                System.out.println("Upper bound limit exceed, upper bound maximum choice is " + this.upBound);
            } else {
                System.out.println("exceed stone remaining" + this.stoneRemain);
            }
        }
    }
    // print the stone remaining
    public void printStone() {
        System.out.print("\n");
        System.out.print(this.stoneRemain + " stones left :");
        for (int i = 0; i < this.stoneRemain; i++) {
            System.out.print(" *");
        }

    }

    public void gameSummary() {
        System.out.println(player1.getPlayerName() + " won "+ player1.getNumOfWin()
                + " game out of " + timesOfGame + " played");
        System.out.println(player2.getPlayerName() + " won "+ player2.getNumOfWin()
                + " game out of " + timesOfGame + " played");
    }
}
