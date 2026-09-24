package com.habittracker;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit tests for Habit.
 */
public class HabitTest
    extends TestCase
{
    private Habit habit;

    public HabitTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( HabitTest.class );
    }

    @Override 
    protected void setUp()
    {
        habit = new Habit( "Read" );
    }

    public void testConstructorSetsName()
    {
        assertEquals( "Read", habit.getName() );
    }

    public void testNewHabitIsNotDone()
    {
        assertFalse( habit.getIsDone() );
    }

    public void testNewHabitHasZeroStreak()
    {
        assertEquals( 0, habit.getStreak() );
    }

    public void testSetNameOverwritesPreviousName()
    {
        habit.setName( "Exercise" );
        assertEquals( "Exercise", habit.getName() );
    }

    public void testIncreaseStreakOnce()
    {
        habit.increaseStreak();
        assertEquals( 1, habit.getStreak() );
    }

    public void testIncreaseStreakMultipleTimes()
    {
        habit.increaseStreak();
        habit.increaseStreak();
        habit.increaseStreak();
        assertEquals( 3, habit.getStreak() );
    }

    public void testSetIsDoneFalseMarksHabitDone()
    {
        habit.setIsDone( false );
        assertTrue( habit.getIsDone() );
    }

    public void testSetIsDoneTrueMarksHabitNotDone()
    {
        habit.setIsDone( true );
        assertFalse( habit.getIsDone() );
    }

    public void testSetIsDoneTrueAfterFalseMarksHabitNotDone()
    {
        habit.setIsDone( false );
        habit.setIsDone( true );
        assertFalse( habit.getIsDone() );
    }

    public void testToggleWithCurrentValueFlipsState()
    {
        habit.setIsDone( habit.getIsDone() );
        assertTrue( habit.getIsDone() );
        habit.setIsDone( habit.getIsDone() );
        assertFalse( habit.getIsDone() );
    }
}
