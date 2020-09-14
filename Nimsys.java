/** Student Name: Xixi Lyu
 * Student id: 1120263
 * User Name: XIXLYU
 */


import java.lang.*;
import java.util.*;

public class Nimsys {
    private static int timesOfGame;
    private String player1;
    private String player2;
    private int upBound;
    private int stoneRemain;
    private static boolean player1Choose;
    public static Scanner keyboard = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("Welcome to Nim\n");
        System.out.println("Please enter a command to continue\n");
        while (true) {
            System.out.print("$ ");
            String command = keyboard.next();
            NimCommand(command);
        }
    }


    /**
     * NimCommand() method:
     * The game will begin by typing in the command start into the command console.
     * The player names should be entered only at the beginning,
     * when launching the game from the command console.
     * @param command
     */
    public static void NimCommand(String command) {
        switch (command) {
            case "start":
                System.out.print("\n");
                nimStart();
                break;
            case "exit":
                System.out.println("\nThank you for playing Nim\n");
                Runtime.getRuntime().exit(0);
            case "help":
                System.out.println("Type 'commands' to list all available commands\n" +
                        "Type 'start' to play game\n" +
                        "Player to remove the last stone loses!");
                break;
            case "commands":
                System.out.println(": start\n" +
                        ": exit\n" +
                        ": help\n" +
                        ": commands\n");
        }
    }


    /**
     * After player type "start", the game start.
     * players play NimGame here
     */
    public static void nimStart() {
        System.out.print("Please enter Player 1's name : ");
        NimPlayer player1 = new NimPlayer(keyboard.next());
        System.out.print("Please enter Player 2's name : ");
        NimPlayer player2 = new NimPlayer(keyboard.next());
        //  the game can play many times until player choose exit the game.
        while (true) {
            System.out.print("Enter upper bound : ");
            int upBound = keyboard.nextInt();
            System.out.print("Enter initial number of stones : ");
            int initialStones = keyboard.nextInt();
            int stoneRemain = initialStones; // at the beginning, number of initial stones is the number of stones remaining
            boolean player1Choose = true;
            while (stoneRemain > 0) {
                System.out.print("\n");
                System.out.print(stoneRemain + " stones left :");
                for (int i = 0; i < stoneRemain; i++) {
                    System.out.print(" *");
                }
                if (player1Choose == true) {
                    while (true) {
                        System.out.print("\n" + player1.getPlayerName() + "'s turn. Enter stones to remove :");
                        int stoneRemove = player1.removeStone(keyboard.nextInt());
                        if (stoneRemove <= stoneRemain && stoneRemove <= upBound) {
                            stoneRemain = stoneRemain - stoneRemove;
                            player1Choose = !(player1Choose);// another player's turn
                            break;
                        } else {
                            System.out.println("Upper bound limit exceed, upper bound maximum choice is " + stoneRemain);
                        }
                    }

                } else {
                    while (true) {
                        System.out.print("\n" + player2.getPlayerName() + "'s turn. Enter stones to remove : ");
                        int stoneRemove = player2.removeStone(keyboard.nextInt());
                        if (stoneRemove <= stoneRemain && stoneRemove <= upBound) {
                            stoneRemain = stoneRemain - stoneRemove;
                            player1Choose = !(player1Choose);// another player's turn
                            break;
                        } else {
                            System.out.println("Upper bound limit exceed, upper bound maximum choice is " + stoneRemain);
                        }
                    }
                }
            }

            System.out.println("\nGame Over");
            timesOfGame++;
            if (player1Choose == true) {
                player1.gameWin();
            } else {
                player2.gameWin();
            }
            System.out.print("Do you want to play again (Y/N): ");
            String whetherContinue = keyboard.next();

            if (!whetherContinue.toUpperCase().equals("Y")) {
            // summary of the game
                System.out.println(player1.getPlayerName() + " won " + player1.getNumOfWin()
                        + " game out of " + timesOfGame + " played");
                System.out.println(player2.getPlayerName() + " won " + player2.getNumOfWin()
                        + " game out of " + timesOfGame + " played");
                break;

            }


        }
    }

}
