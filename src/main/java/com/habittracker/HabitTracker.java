package com.habittracker;

import java.util.ArrayList;

public class HabitTracker {

    private final ArrayList<Habit> habits;

    public HabitTracker() {
        habits = new ArrayList<>();
    }

    public static void main(String[] args) {
        HabitTracker ht = new HabitTracker();
        String habit1 = "Karate";
        String habit2 = "Sleeping";
        String habit3 = "Hello mama";

        ht.createHabit(habit1);
        ht.createHabit(habit2);
        ht.createHabit(habit3);

        System.out.println(ht.toString());
    }

    public void createHabit(String habitName) {
        Habit habit = new Habit(habitName);
        habits.add(habit);
    }

    public ArrayList<Habit> getHabitList() {
        return habits;
    }

    public String getHabits() {
        String s = "";
        String habitDetails;
        for (Habit habit : habits) {
            habitDetails = "\n" + habit.getName() + "\n" + habit.getIsDone() +"\n"+ habit.getStreak(); 
            s = s + habitDetails;
        }
        return s;
    }

    public Habit getHabit(String habitName) {
        Habit curHabit = null;
        int length = habits.size();
        if (length < 1) {
            System.err.println("You currently no habits");
            return null;
        }
        for (Habit habit : habits) {
            if (habit.getName().equals(habitName)) {
                curHabit = habit;
            }

        }
        return curHabit;
    }

    public void completeHabit(String habitName, boolean done) {
        Habit currHabit = getHabit(habitName);
        boolean isDone = currHabit.getIsDone();
        getHabit(habitName).setIsDone(isDone);
    }

    public void incrementStreak(String habitName) {
        getHabit(habitName).increaseStreak();
    }

    @Override
    public String toString() {

        return getHabits() + "\n These are all the habits";
    }
}
