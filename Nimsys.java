/** Student Name: Xixi Lyu
 * Student id: 1120263
 * User Name: XIXLYU
 *
 */


import java.lang.*;
import java.util.*;

public class Nimsys {

    private static int timesOfGame;
    private String player1;
    private String player2;
    private int upBound;
    private int stoneRemain;
    private static boolean player1Turn;
    public static Scanner keyboard = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("Welcome to Nim\n");
        System.out.println("\nPlease enter a command to continue\n");
        while (true) {
            System.out.print("$ ");
            String command = keyboard.next();
            NimCommand(command);
        }
    }


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

    public static void nimStart() {
        System.out.print("Please enter Player 1's name : ");
        NimPlayer player1 = new NimPlayer(keyboard.next());
        System.out.print("Please enter Player 2's name : ");
        NimPlayer player2 = new NimPlayer(keyboard.next());

        while (true) {
            /** collect game information
             */
            System.out.print("Enter upper bound : ");
            int upBound = keyboard.nextInt();
            System.out.print("Enter initial number of stones : ");
            int stoneRemain = keyboard.nextInt();

            boolean player1Turn = true;
            /**
             * stone not empty, continue the game
             */
            while (stoneRemain > 0) {


                /** print remaining stones
                 */
                System.out.print("\n");
                System.out.print(stoneRemain + " stones left :");
                for (int i = 0; i < stoneRemain; i++) {
                    System.out.print(" *");
                }
                /**
                 *
                 */
                if (player1Turn == true) {
                    while (true) {
                        System.out.print("\n" + player1.getPlayerName() + "'s turn. Enter stones to remove : ");
                        int stoneRemove = player1.removeStone(keyboard.nextInt());
                        if (stoneRemove <= stoneRemain && stoneRemove <= upBound) {
                            stoneRemain = stoneRemain - stoneRemove;
                            player1Turn = !(player1Turn);
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
                            player1Turn = !(player1Turn);
                            break;
                        } else {
                            System.out.println("Upper bound limit exceed, upper bound maximum choice is " + stoneRemain);
                        }
                    }
                }
            }


            /**
             * one game over, check whether start a new game
             */
            System.out.println("\nGAME OVER");
            timesOfGame++;
            if (player1Turn == true) {
                player1.gameWin();
            } else {
                player2.gameWin();
            }

            System.out.print("Do you want to play again (Y/N): ");
            String whetherContinue = keyboard.next();

            if (!whetherContinue.toUpperCase().equals("Y")) {

                System.out.println(player1.getPlayerName() + " won " + player1.getNumOfWin()
                        + " game out of " + timesOfGame + " played");
                System.out.println(player2.getPlayerName() + " won " + player2.getNumOfWin()
                        + " game out of " + timesOfGame + " played");
                break;

            }


        }
    }

}









