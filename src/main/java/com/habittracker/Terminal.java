package com.habittracker;

import java.util.Scanner;

public class Terminal {

    private final static String[] COMMANDS = {"add", "complete", "undo"};
    private final Scanner inputStr;

    public static void main(String[] args){
        HabitTracker ht = new HabitTracker();
        Terminal terminal = new Terminal(ht);
        
    }

    public Terminal(HabitTracker ht) {
        System.out.println("Hello welcome to the habit tracker");
        inputStr = new Scanner(System.in);
        start(ht);
        inputStr.close();

    }

    private void start(HabitTracker ht) {
        //Applet starts 
        System.out.println("What would you like to do?:" + String.join(", ", COMMANDS));
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
            if (!found) {
                throw new WrongCommandException(" Invalid command, please choose between " + String.join(", ", COMMANDS));
            }

            execute(command, ht);

        } catch (WrongCommandException e) {
            System.out.println(e.getMessage());
            System.out.println("Please try again");
            start(ht);

        }
    }

    public void execute(String command, HabitTracker ht) {
        String habitName = inputStr.nextLine();
        if (command.equals(COMMANDS[0])) {
            ht.createHabit(habitName);
            System.out.println(ht.getHabit(habitName).getName()+ " was created ");
        }

        if (command.equals(COMMANDS[1])){
            ht.createHabit(habitName);
        }
    }

    public class WrongCommandException extends Exception {

        public WrongCommandException(String message) {
            super(message);
        }
    }
}
