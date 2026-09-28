package com.habittracker;

import java.util.ArrayList;

public class HabitTracker {

    private final ArrayList<Habit> habits;

    public HabitTracker() {
        habits = new ArrayList<>();
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

        if (isDone == false){
            currHabit.increaseStreak();
        }else {
            // currHabit.decreaseStreak();
        }
    }

    @Override
    public String toString() {

        return getHabits() + "\n These are all the habits";
    }
}
