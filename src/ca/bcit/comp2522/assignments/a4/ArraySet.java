package ca.bcit.comp2522.assignments.a4;

import java.util.Arrays;

/**
 * <p>ArraySet is a resizeable-array implementation of the Set interface. It
 * contains a set of elements in no particular order that excludes duplicates or
 * nulls.</p>
 * 
 * <p>Elements may be added to, removed from, and searched for in the ArraySet. As
 * elements are added to the ArraySet its capacity is resized automatically.</p>
 * 
 * <p>ArraySet contains a SetIterator that permits access to the elements in the
 * ArraySet one at a time.</p>
 * 
 * @author Dongmin Lee (A01165938)
 * @version 2020
 * @invariant The ArraySet never contains duplicate elements.
 * @invariant The ArraySet never contains nulls.
 */
public class ArraySet<E> implements Set<E>, MyIterable<E> {

    /**
     * The initial capacity of the ArraySet.
     */
    public static final int INITIAL_CAPACITY = 10;

    /**
     * The capacity of the ArraySet.
     */
    protected int capacity;

    /**
     * The number of elements contained in the ArraySet.
     */
    protected int elementCount;

    /**
     * The array buffer that stores the elements of the ArraySet.
     */
    protected E[] collection;

    /**
     * Constructs a new empty ArraySet of default initial capacity 10.
     * 
     * @pre true
     * @post size() = 0.
     */
    public ArraySet() {
        this.capacity = INITIAL_CAPACITY;
        this.elementCount = 0;
        this.collection = (E[]) new Object[capacity];
    }

    /**
     * Adds the specified element to the ArraySet if it is not already present.
     *
     * @param element The element to be added to the set.
     * @pre true
     * @post IF ( element != null AND NOT @pre.contains(element) ) THEN
     *       contains(element) ELSE the ArraySet is not changed
     * @return true if the ArraySet did not already contain the specified
     *         element, else false.
     */
    public boolean add(final E element) {
        if (element != null && !this.contains(element)) {
            if (elementCount == capacity) {
                resize();
            }
            collection[elementCount++] = element;
            return true;
        }
        return false;
    }

    /**
     * Removes the specified element from the ArraySet if it exists.
     * 
     * @param element The element to be removed, if present.
     * @pre true
     * @post IF @pre.contains(element) THEN NOT contains(element) ELSE the
     *       ArraySet is not changed
     * @return true if element was removed from the ArraySet, else false.
     */
    public boolean remove(final E element) {
        if (this.contains(element)) {
            for (int index = 0; index < elementCount; index++) {
                if (collection[index].equals(element)) {
                    if (elementCount == index + 1) {
                        collection[index] = null;
                    } else {
                        collection[index] = collection[elementCount - 1];
                        collection[elementCount] = null;
                    }
                    elementCount--;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Removes all elements from the ArraySet. The ArraySet will be empty after
     * this call returns.
     * 
     * @pre true
     * @post size() = 0
     */
    public void clear() {
        E[] newCollection = (E[]) new Object[capacity];
        collection = newCollection;
        elementCount = 0;
    }

    /**
     * Returns true if this ArraySet contains the specified element.
     * 
     * @param element The element to be checked for containment.
     * @pre true
     * @post true
     * @return true if element is in the ArraySet, and false otherwise.
     */
    public boolean contains(final E element) {
        for (int index = 0; index < elementCount; index++) {
            if (collection[index].equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the number of elements in the ArraySet (its cardinality).
     * 
     * @pre true
     * @post true
     * @return The number of elements in the ArraySet.
     */
    public int size() {
        return elementCount;
    }

    /**
     * Doubles the size of the ArraySet.
     * 
     * @pre true
     * @post the capacity of the ArraySet is doubled.
     */
    private void resize() {
        final int doubleCapacity = 2;
        this.capacity *= doubleCapacity;
        E[] newCollection = (E[]) new Object[capacity];
        if (elementCount >= 0) {
            System.arraycopy(collection, 0, newCollection, 0, elementCount);
        }
        collection = newCollection;
    }

    /**
     * Creates and returns an array containing the elements of the ArraySet.
     * 
     * @pre true
     * @post true
     * @return an unordered array containing the elements of the ArraySet.
     */
    public Object[] toArray() {
        return Arrays.copyOfRange(collection, 0, elementCount);
    }

    /**
     * Returns an iterator over the elements in this ArraySet. The elements are
     * returned in no particular order.
     * 
     * @pre true
     * @post true
     * @return an iterator for the ArraySet of elements that points to the first
     *         element in the ArraySet.
     */
    public SetIterator<E> iterator() {
        return this.new SetIterator<>();
    }

    /**
     * SetIterator provides a means for iterating over the elements of an
     * ArraySet.
     */
    public class SetIterator<E> implements MyIterator<E> {

        private int currentIndex = 0;
        private final int size = size();

        /**
         * Returns true if the iteration has more elements.
         * 
         * @pre true
         * @post true
         * @return true if the iteration has more elements, false otherwise.
         */
        public boolean hasNext() {
            return currentIndex < size;
        }

        /**
         * Returns the next element in the iteration and advances to point to
         * the next.
         * 
         * @pre @pre.hasNext()
         * @post SetIterator points to the next element in the ArraySet.
         * @return the element pointed to by the SetIterator when the method is
         *         called.
         */
        public E next() {
            return (E) collection[currentIndex++];
        }
    }
}
