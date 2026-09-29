# Habit Tracker

A small command-line habit tracker written in Java. You add habits by name, mark them as complete, and each habit keeps a streak of how many times you've completed it.

> **Status:** work in progress. Adding a habit works. `complete` and `undo` are still being built.

## Requirements

- A Java JDK (tested with Java 25)
- Maven (tested with 3.9)

## Getting started

Clone the repo and build it:

```bash
git clone <repo-url>
cd habit-tracker
mvn compile
```

Run the app:

```bash
java -cp target/classes com.habittracker.Terminal
```

When the app asks what you want to do, type a command, press Enter, then type the habit name:

```
Hello welcome to the habit tracker
What would you like to do?:add, complete, undo
add
Read
Read was created
```

## Commands

| Command    | What it does                                          | Status      |
|------------|-------------------------------------------------------|-------------|
| `add`      | Creates a new habit with the name you type next       | Working     |
| `complete` | Marks a habit as done and adds 1 to its streak        | In progress |
| `undo`     | Reverses the last completion                          | Planned     |

If you type anything else, the app lists the valid commands and asks again.

## Project structure

```
src/main/java/com/habittracker/
├── Habit.java          A single habit: name, done status, and streak
├── HabitTracker.java   Stores the list of habits and finds or completes them
└── Terminal.java       Reads commands from the keyboard (the app's entry point)

src/test/java/com/habittracker/
└── HabitTest.java      Unit tests for Habit
```

## Running the tests

```bash
mvn test
```

The tests use JUnit 3.

## Built with

- Java
- Maven
- JUnit
