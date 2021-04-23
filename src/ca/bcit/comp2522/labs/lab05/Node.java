package ca.bcit.comp2522.labs.lab05;

import java.util.Objects;

/**
 * Node for linked list, holds data and reference to the next node.
 *
 * @author Dongmin Lee
 * @version 2020
 */
public class Node {
    private Object data;
    private Node next;

    /**
     * Constructs a new node with passed argument as data.
     *
     * @param data an object
     */
    public Node(Object data) {
        this.data = data;
        this.next = null;
    }

    /**
     * Gets data.
     *
     * @return data of the node
     */
    public Object getData() {
        return data;
    }

    /**
     * Sets data.
     *
     * @param data new data
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * Sets next.
     *
     * @param next new next
     */
    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * Gets next.
     *
     * @return next node
     */
    public Node getNext() {
        return next;
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
        Node node = (Node) o;
        if (!Objects.equals(data, node.data)) {
            return false;
        }
        return Objects.equals(next, node.next);
    }

    /**
     * Calculates hash code of the current object.
     *
     * @return hash code
     */
    @Override
    public int hashCode() {
        int primeNum = 31;
        int result = data != null ? data.hashCode() : 0;
        result = primeNum * result + (next != null ? next.hashCode() : 0);
        return result;
    }

    /**
     * Returns description of the current object.
     *
     * @return field values in string format
     */
    @Override
    public String toString() {
        return "Node{"
                + "data=" + data
                + ", next=" + next
                + '}';
    }
}
