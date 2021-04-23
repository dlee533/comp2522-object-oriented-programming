package ca.bcit.comp2522.labs.lab06;

/**
 * LinkedList class with methods to add and delete nodes.
 *
 * @author Dongmin Lee
 * @version 2020
 * @param <T>
 */
public class LinkedList<T> {

    private Node<T> head;
    private int numElement;

    static class Node<T> {
        private T data;
        private Node<T> next;


        Node(final T data) {
            this.data = data;
            this.next = null;
        }

        public Object getData() {
            return data;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getNext() {
            return next;
        }
    }

    /**
     * Constructs the linked list object.
     */
    public LinkedList() {
        head = null;
        numElement = 0;
    }

    /**
     * Gets the size.
     *
     * @return number of elements in the linked list
     */
    public int getSize() {
        return numElement;
    }

    /**
     * Prepends a node to the existing list.
     *
     * @param data an object to be prepended
     */
    public void prepend(final T data) {
        Node<T> newNode = new Node<>(data);
        if (head != null) {
            newNode.setNext(head);
        }
        head = newNode;
        numElement++;
    }

    /**
     * Appends a node to the existing list.
     *
     * @param data an object to be appended
     */
    public void append(final T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> iterator = head;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
        }
        numElement++;
    }

    /**
     * Adds a node to the existing list at specified index.
     *
     * @param data an object to add
     * @param index location for the object to be added to
     * @throws IndexOutOfBoundsException if the index is negative or bigger than the
     * number of elements in the list
     */
    public void add(final T data, final int index) {
        if (index < 0 || index > numElement + 1) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> newNode = new Node<>(data);
        if (index == 0) {
            prepend(data);
        } else if (index == numElement) {
            append(data);
        }
        Node<T> iterator = head;
        for (int currentIndex = 0; currentIndex < index - 1; currentIndex++) {
            iterator = iterator.getNext();
        }
        newNode.setNext(iterator.getNext());
        iterator.setNext(newNode);
        numElement++;
    }

    /**
     * Returns size.
     *
     * @return numElement, integer value
     */
    public int size() {
        return numElement;
    }

    /**
     * Clears the linked list.
     */
    public void clear() {
        head = null;
        numElement = 0;
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
        Node<T> iterator = head;
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
    public Object remove(final int index) {
        if (checkIfInvalidIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> iterator = head;
        if (index == 0) {
            head = head.getNext();
        } else {
            Node<T> previous = null;
            for (int currentIndex = 0; currentIndex < index; currentIndex++) {
                previous = iterator;
                iterator = iterator.getNext();
            }
            if (previous != null) {
                previous.setNext(iterator.getNext());
            }
        }
        numElement--;
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
    public int count(final T o) throws EmptyListException {
        if (o == null) {
            throw new IllegalArgumentException("You cannot count a null object.");
        } else if (size() == 0) {
            throw new EmptyListException("The list is empty.");
        }
        int count = 0;
        Node<T> iterator = head;
        for (int index = 0; index < numElement; index++) {
            if (iterator.getData().equals(o)) {
                count++;
            }
            iterator = iterator.getNext();
        }
        return count;
    }

    private boolean checkIfInvalidIndex(final int index) {
        return !(index < numElement && index >= 0);
    }

    /**
     * checks if the argument is equal to current object.
     *
     * @param o Object to compare
     * @return boolean value, whether o is equal to current object
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LinkedList<T> that = (LinkedList<T>) o;
        if (numElement != that.numElement) {
            return false;
        }
        Node<T> iter = head;
        Node<T> iter2 = that.head;
        for (int index = 0; index < numElement; index++) {
            if (!iter.getData().equals(iter2.getData())) {
                return false;
            }
            iter = iter.getNext();
            iter2 = iter2.getNext();
        }
        return true;
    }

    /**
     * Calculates hash code of the current object.
     *
     * @return hash code
     */
    @Override
    public int hashCode() {
        final int primeNum = 31;
        int result = primeNum * numElement;
        Node<T> iter = head;
        for (int index = 0; index < numElement; index++) {
            result = primeNum * iter.hashCode();
            iter = iter.getNext();
        }
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
                + ", numElement=" + numElement
                + '}';
    }

//    /**
//     * Tests the class - created for quiz.
//     *
//     * @param args command line argument
//     * @throws EmptyListException if the Object o is null when counting
//     */
//    public static void main(String[] args) throws EmptyListException {
//        LinkedList<Integer> test = new LinkedList<>();
//        test.append(1);
//        test.append(2);
//        test.append(4);
//        test.add(3, 2);
//        test.prepend(0);
//        System.out.println("Size: " + test.size());
//        System.out.println("Count: " + test.count(0));
//        System.out.println("Index 2 == " + test.get(2));
//        System.out.println("Index 2 removed : " + test.remove(2));
//        System.out.println("New Index 2 == " + test.get(2));
//        test.clear();
//        System.out.println("Cleared size: " + test.size());
//
//        LinkedList<String> test1 = new LinkedList<>();
//        test1.append("B");
//        test1.append("C");
//        test1.append("E");
//        test1.add("D", 2);
//        test1.prepend("A");
//        System.out.println("Size: " + test1.size());
//        System.out.println("Count: " + test1.count("A"));
//        System.out.println("Index 2 == " + test1.get(2));
//        System.out.println("Index 2 removed : " + test1.remove(2));
//        System.out.println("New Index 2 == " + test1.get(2));
//        test1.clear();
//        System.out.println("Cleared size: " + test1.size());
//    }
}
