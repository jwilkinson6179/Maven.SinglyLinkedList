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
    public void itsARemoveTest()
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
    public void getTest()
    {
        String expected = "LOOKING";
        SinglyLinkedList<String> test = new SinglyLinkedList<>();
        test.add("The");
        test.add("Term");
        test.add("I'm");
        test.add(expected);
        test.add("For");
        String actual = test.get(3);

        assertEquals(expected, actual);
    }

    @Test
    public void copyTest()
    {
        SinglyLinkedList<String> test = new SinglyLinkedList<String>();
        test.add("A");
        SinglyLinkedList<String> copiedTest = test.copy();
        test.add("B");

        assertTrue(copiedTest.contains("A"));
        assertFalse(copiedTest.contains("B"));
    }

    @Test
    public void sliceTest()
    {
        String expected = "{ A, B }";
        SinglyLinkedList<String> test = new SinglyLinkedList<>();
        test.add("A");
        test.add("B");
        test.add("C");

        SinglyLinkedList<String> subList = test.slice(0, 2);
        String actual = subList.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void sliceTestTwo()
    {
        String expected = "{ 3, 4 }";
        SinglyLinkedList<Integer> test = new SinglyLinkedList<>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);

        SinglyLinkedList<Integer> slicedList = test.slice(2, 4);
        String actual = slicedList.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void reverseTest()
    {
        String expected = "{ 5, 4, 3, 2, 1 }";
        SinglyLinkedList<Integer> test = new SinglyLinkedList<>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);
        test.reverse();
        String actual = test.toString();

        assertEquals(expected, actual);
    }

}