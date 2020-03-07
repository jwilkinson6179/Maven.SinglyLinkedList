package com.zipcodewilmington.singlylinkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

public class SinglyLinkedListTest
{
    @Test
    public void constructorTest()
    {
        SinglyLinkedList<Integer> test = new SinglyLinkedList<Integer>();
    }

    @Test
    public void addTest()
    {
        Integer expected = 0;
        String addedValue = "Hello";
        SinglyLinkedList<String> test = new SinglyLinkedList<String>();

        test.add(0, addedValue);
        Integer actual = test.find(addedValue);

        assertEquals(expected, actual);
    }

    @Test
    public void addTwoTest()
    {
        Integer expected = 0;
        Integer addedValue = 10;
        SinglyLinkedList<Integer> test = new SinglyLinkedList<Integer>();

        test.add(addedValue);
        test.add(20);
        test.add(30);
        Integer actual = test.find(addedValue);

        assertEquals(expected, actual);
    }

    @Test
    public void itsATest()
    {
        Integer expected = 0;
        SinglyLinkedList<Integer> test = new SinglyLinkedList<Integer>();

        test.add(1);
        test.remove(0);
        Integer actual = test.size();

        assertEquals(expected, actual);
    }

    @Test
    public void containsTest()
    {
        Boolean expected = false;
        SinglyLinkedList<Integer> test = new SinglyLinkedList<Integer>();

        Boolean actual = test.contains(100);

        assertEquals(expected, actual);
    }

    @Test
    public void containsTest2()
    {
        Boolean expected = true;
        SinglyLinkedList<Integer> test = new SinglyLinkedList<Integer>();

        test.add(100);
        Boolean actual = test.contains(100);

        assertEquals(expected, actual);
    }

    @Test
    public void containsTest3()
    {
        Boolean expected = true;
        SinglyLinkedList<Integer> test = new SinglyLinkedList<Integer>();

        test.add(100);
        test.add(200);
        Boolean actual = test.contains(100);

        assertEquals(expected, actual);
    }

    @Test
    public void copyTest()
    {
        SinglyLinkedList<String> test = new SinglyLinkedList<String>();
        test.add("A");
        SinglyLinkedList<String> copiedTest = test.copy();
        test.add("!");

        assertFalse(copiedTest.contains("!"));
        assertTrue(copiedTest.contains("A"));
    }
}