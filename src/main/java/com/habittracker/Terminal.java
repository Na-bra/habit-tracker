package com.habittracker;

import java.util.Scanner;

public class Terminal {

    private final static String[] COMMANDS = {"add", "complete", "undo"};
    private Scanner inputStr;

    public Terminal(HabitTracker ht) {
        System.out.print("Hello welcome to the habit tracker");
        inputStr = new Scanner(System.in);
        start();

    }

    private void start(HabitTracker ht) {
        //Applet starts 
        String command = inputStr.nextLine();
        readCommand(command, ht);

    }

    public void readCommand(String command, HabitTracker ht) {
        int numberOfCommands = COMMANDS.length;
        boolean found = false;
        try {
            for (int i = 0; i < numberOfCommands; i++) {
                if (command.equals(COMMANDS[i])) {
                    found = true;
                    break;
                }

            }
            if (!found){
              throw new WrongCommandException(" Invalid command, please choose between " + String.join(", ", COMMANDS));
            }

            
        } catch (WrongCommandException e) {
            System.out.println(e.getMessage());
            System.out.println("Please try again");
            start(ht);

        }
    }

    

    public class WrongCommandException extends Exception {

        public WrongCommandException(String message) {
            super(message);
        }
    }
}
