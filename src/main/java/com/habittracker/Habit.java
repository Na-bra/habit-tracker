package com.habittracker;

public final class Habit {

    private String name;
    private boolean isDone = false;
    private int streak = 0;

    public Habit(String name){
      setName(name);
    }

    public String getName() {
        return name;
    }

    public boolean getIsDone() {
        return isDone;
    }

    public int getStreak() {
        return streak;
    }

    public void setName(String name){
      this.name = name;
    }

    public void increaseStreak(){
      streak++;
    }
    public void setIsDone(boolean isDone){
      this.isDone = !isDone;
    }
}
