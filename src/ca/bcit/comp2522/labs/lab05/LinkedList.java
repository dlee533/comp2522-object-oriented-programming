package ca.bcit.comp2522.labs.lab05;

import java.util.Objects;

/**
 * LinkedList class with methods to add and delete nodes.
 *
 * @author Dongmin Lee
 * @version 2020
 */
public class LinkedList {
    private Node head;
    private int size;

    /**
     * Constructs the linked list object.
     */
    public LinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Gets size.
     *
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * Prepends a node to the existing list.
     *
     * @param data an object to be prepended
     */
    public void prepend(final Object data) {
        Node newNode = new Node(data);
        if (head != null) {
            newNode.setNext(head);
        }
        head = newNode;
        size++;
    }

    /**
     * Appends a node to the existing list.
     *
     * @param data an object to be appended
     */
    public void append(final Object data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node iterator = head;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
        }
        size++;
    }

    /**
     * Adds a node to the existing list at specified index.
     *
     * @param data an object to add
     * @param index location for the object to be added to
     * @throws IndexOutOfBoundsException if the index is negative or bigger than the
     * number of elements in the list
     */
    public void add(Object data, int index) {
        if (checkIfInvalidIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
        Node newNode = new Node(data);
        Node iterator = head;
        for (int currentIndex = 0; currentIndex < index-1; currentIndex++) {
            iterator = iterator.getNext();
        }
        newNode.setNext(iterator.getNext());
        iterator.setNext(newNode);
        size++;
    }

    /**
     * Returns size.
     *
     * @return numElement, integer value
     */
    public int size() {
        return size;
    }

    /**
     * Clears the linked list.
     */
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * Gets the value at index location.
     *
     * @param index integer location of where the wanted data is stored
     * @return the object
     * @throws IndexOutOfBoundsException if the index is negative or bigger than the
     * number of elements in the list
     */
    public Object get(final int index) {
        if (checkIfInvalidIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
        Node iterator = head;
        for (int currentIndex = 0; currentIndex < index; currentIndex++) {
            iterator = iterator.getNext();
        }
        return iterator.getData();
    }

    /**
     * Remove the object at specified index and return it.
     *
     * @param index integer location of where the wanted data is stored
     * @return the object
     * @throws IndexOutOfBoundsException if the index is negative or bigger
     * than the number of elements in the list
     */
    public Object remove(int index) {
        if (checkIfInvalidIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
        Node iterator = head;
        if (index == 0) {
            head = head.getNext();
        } else {
            Node previous = null;
            for (int currentIndex = 0; currentIndex < index; currentIndex++) {
                previous = iterator;
                iterator = iterator.getNext();
            }
            previous.setNext(iterator.getNext());
        }
        size--;
        return iterator.getData();
    }

    /**
     * Counts number of an Object in the LinkedList.
     *
     * @param o an Object
     * @return an int
     * @throws IllegalArgumentException if the Object o is null
     * @throws EmptyListException if the LinkedList is empty
     */
    public int count(Object o) throws EmptyListException {
        if (o == null) {
            throw new IllegalArgumentException("You cannot count a null object.");
        } else if (size() == 0) {
            throw new EmptyListException("The list is empty.");
        }
        int count = 0;
        Node iterator = head;
        for (int index = 0; index < size; index++) {
            if (iterator.getData().equals(o)) {
                count++;
            }
            iterator = iterator.getNext();
        }
        return count;
    }

    private boolean checkIfInvalidIndex(int index) {
        return !(index < size && index >= 0);
    }

    /**
     * checks if the argument is equal to current object.
     *
     * @param o Object to compare
     * @return boolean value, whether o is equal to current object
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LinkedList that = (LinkedList) o;
        if (size != that.size) {
            return false;
        }
        return Objects.equals(head, that.head);
    }

    /**
     * Calculates hash code of the current object.
     *
     * @return hash code
     */
    @Override
    public int hashCode() {
        int primeNum = 31;
        int result = head != null ? head.hashCode() : 0;
        result = primeNum * result + size;
        return result;
    }

    /**
     * Returns description of the current object.
     *
     * @return field values in string format
     */
    @Override
    public String toString() {
        return "LinkedList{"
                + "head=" + head
                + ", numElement=" + size
                + '}';
    }

    /**
     * Tests the class - created for quiz.
     *
     * @param args command line argument
     * @throws EmptyListException if the Object o is null when counting
     */
    public static void main(String[] args) throws EmptyListException {
        LinkedList test = new LinkedList();
        test.append(1);
        test.append(2);
        test.append(4);
        test.add(3, 2);
        test.prepend(0);
        System.out.println("Size: " + test.size());
        System.out.println("Count: " + test.count(1));
        System.out.println("Index 2 == " + test.get(2));
        System.out.println("Index 2 removed : " + test.remove(2));
        System.out.println("New Index 2 == " + test.get(2));
        test.clear();
        System.out.println("Cleared size: " + test.size());
    }
}