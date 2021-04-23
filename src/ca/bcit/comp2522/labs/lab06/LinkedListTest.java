package ca.bcit.comp2522.labs.lab06;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the Linked List.
 * @author Karel Chanivecky Garcia
 * @version 2020
 */
public class LinkedListTest {
    LinkedList<Integer> testList1 = new LinkedList<>();
    LinkedList<Integer> testList2 = new LinkedList<>();
    LinkedList<Integer> testList3 = new LinkedList<>();
    LinkedList<Integer> testList4 = new LinkedList<>();
    LinkedList<Integer> testList5 = new LinkedList<>();
    LinkedList<Integer> testList6 = new LinkedList<>();
    LinkedList<Integer> testList7 = new LinkedList<>();
    LinkedList<String> testList8 = new LinkedList<>();


    @Before
    public void setUp() {
        for (int i = 0; i < 10; i++) {
            testList1.append(i);
            testList2.append(i + 5);
            testList3.append(i + 10);
            testList4.prepend(i);
            testList5.append(i);
            testList6.append(i);
            testList7.append(i);
        }
        testList5.append(9);
        testList6.append(8);
        testList8.append("A");
    }

    @Test
    public void count() throws EmptyListException {
        assertEquals(1, testList8.count("A"));
        assertEquals(0, testList8.count("C"));
    }

    @Test
    public void remove(){
        assertEquals("A", testList8.remove(0));
    }


    @Test
    public void append() throws Exception{
        testList3.append(50);
        assertEquals(50, testList3.get(testList3.getSize() - 1));
        testList8.append("B");
        assertEquals("B", testList8.get(testList8.getSize() - 1));
    }

    @Test
    public void prepend() throws Exception{
        testList2.prepend(1);
        assertEquals(1, testList2.get(0));
        testList8.prepend("C");
        assertEquals("C", testList8.get(0));
    }

    @Test
    public void add() throws Exception{
        testList2.add(44, 3);
        assertEquals(44, testList2.get(3));
        testList8.add("D", 1);
        assertEquals("D", testList8.get(1));
    }

    @Test
    public void clear() {
        testList3.clear();
        assertEquals(0, testList3.getSize());
        testList8.clear();
        assertEquals(0, testList8.getSize());
    }

    @Test
    public void getSize() {
        assertEquals(10, testList1.getSize());
        assertEquals(1, testList8.getSize());
    }


    @Test
    public void testEqualsNot() {
        assertFalse(testList1.equals(testList2));
        assertFalse(testList8.equals(testList2));
    }

    @Test
    public void testEqualsPartialAnagram() {
        assertFalse(testList5.equals(testList6));
    }

    @Test
    public void testEqualsEmpty() {
        LinkedList testList7 = new LinkedList();
        LinkedList testList9 = new LinkedList();
        assertTrue(testList7.equals(testList9));
    }

    @Test
    public void testEqualsUnequalSize() {
        testList3.clear();
        assertFalse(testList1.equals(testList3));
        assertFalse(testList8.equals(testList3));
    }

    @Test
    public void testEquals() {
        assertTrue(testList1.equals(testList7));
    }

    @Test
    public void testEqualsSameElementsDifferentOrder() {
        assertTrue(testList1.equals(testList7));
    }
}