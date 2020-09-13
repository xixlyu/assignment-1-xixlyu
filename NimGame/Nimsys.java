package NimGame;
import java.lang.*;
import java.util.*;

public class Nimsys {
    public static Scanner keyboard = new Scanner(System.in);
    public static void NimCommand(String command){
        switch (command){
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



    public static void main(String[] args)
    {
        System.out.println("Welcome to Nim\n");
        System.out.println("\nPlease enter a command to continue\n");
        while (true) {
            System.out.print("$ ");
            String command = keyboard.next();
            NimCommand(command);
        }
    }


    public static void nimStart(){
        NimGame newGame = new NimGame(keyboard);
        while(true){
            newGame.playGame(keyboard);
            System.out.print("Do you want to play again (Y/N): ");
            String whetherContinue = keyboard.next();

            if ( !whetherContinue.toUpperCase().equals("Y")) {
//            System.out.println("###########################################print summary");
                newGame.gameSummary();
                break;
            }
        }
    }

}
