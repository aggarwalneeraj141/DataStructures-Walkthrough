import java.util.Iterator;

/**
 * Implementation of a Doubly Linked List in Java.
 * Has a head node, end node, as well as a size variable.
 */
public class DoublyLinkedList<E> {

    private DoubleNode head;
    private DoubleNode end;
    private int size;

    public String toString()
    {
        DoubleNode node = head;
        if (node == null)
            return "[]";
        String s = "[";
        while (node.getNext() != null)
        {
            s += node.getValue() + ", ";
            node = node.getNext();
        }
        return s + node.getValue() + "]";
    }

    /**
     * Constructor for the Doubly Linked List. Sets head and end to null, and
     * size to 0.
     */
    public DoublyLinkedList() {
        this.head = null;
        this.end = null;
        this.size = 0;
    }

    /**
     * Get the desired node, iterating from the first node.
     *
     * @param index: the index of the node to get.
     * @return: the node at the given index.
     */
    private DoubleNode getNodeFromFirst(int index) {
        DoubleNode current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    /**
     * Get the desired node, iterating from the last node.
     *
     * @param index: the index of the node to get.
     * @return: the node at the given index.
     */
    private DoubleNode getNodeFromLast(int index) {
        DoubleNode current = this.end;
        for (int i = this.size-1; i > index; i--) {
            current = current.getPrevious();
        }
        return current;
    }

    /**
     * Get node at index in the list. based on the placement, it will
     * iterate from the front or the back of the list to retrieve the value.
     *
     * @param index: the index of the node to get.
     * @return: the node at the specific index.
     */
    //private because only deal with actual values
    private DoubleNode getNode(int index) {
        if (index > this.size/2) {
            return getNodeFromLast(index);
        }
        return getNodeFromFirst(index);
    }


    /**
     * Retrieves the value of the node at the index.
     *
     * @param index: the index of which to retrieve the value.
     * @return: the value of the node.
     */
    public E get(int index) {
        return (E) getNode(index).getValue();
    }

    /**
     * Will retrieve the first value in the list.
     *
     * @return: the first value in the list, or null if the list is empty.
     */
    public E getFirst() {
        if (this.head != null) {
            return (E) this.head.getValue();
        }
        return null;
    }

    /**
     * Will retrieve the last value in the list.
     *
     * @return: the last value in the list, or null if the list is empty.
     */
    public E getLast() {
        if (this.end != null) {
            return (E) end.getValue();
        }
        return null;
    }

    /**
     * Set the value of the node at the specified index, returning
     * the old value at that index.
     *
     * @param index: the index of which to set the value.
     * @param newValue: the new value to be set.
     * @return: the old value.
     */
    public E set(int index, E newValue) {
        E oldValue = get(index);
        getNode(index).setValue(newValue);
        return oldValue;
    }

    /**
     * adds the value to the end of the linked list.
     *
     * @postcondition: the value will be added to the linked list, and the size will increase
     * by one.
     * @param value: the value to be added to the end of the list.
     */
    public void add(E value) {
        DoubleNode newNode = new DoubleNode(value);
        if (this.size == 0) {
            this.head = newNode;
        } else if (this.size == 1) {
            this.end = newNode;
            head.setNext(this.end);
            end.setPrevious(this.head);
        } else {
            end.setNext(newNode);
            newNode.setPrevious(end);
            this.end = newNode;
        }
        this.size++;
    }

    /**
     * Add the value at the selected index and shift all following nodes to the right.
     *
     * @precondition: 0 <= index < size
     * @postcondition: all nodes after the index will be shifted to the right and the size
     * of the list will increase by one
     * @param index: the index at which to insert the value
     * @param value: the value to be inserted into the list
     */
    public void add(int index, E value) {
        DoubleNode newNode = new DoubleNode(value);
        DoubleNode oldNode = getNode(index);
        if (index == 0) {
            if (this.head != null) {
                head.setPrevious(newNode);
            }
            newNode.setNext(head);
            this.head = newNode;
        } else {
            newNode.setPrevious(oldNode.getPrevious());
            newNode.getPrevious().setNext(newNode);
            oldNode.setPrevious(newNode);
            newNode.setNext(oldNode);
        }
        if (size == 1) {
            end = head.getNext();
        }
        this.size++;
    }

    /**
     * Inserts a new value at the front of the list.
     *
     * @postcondition: the private variable head will now point to a node consisting
     * of the passed value, and the size will increase by one.
     * @param value: the value to be inserted at the front of the list
     */
    public void addFirst(E value) {
        DoubleNode newNode = new DoubleNode(value);
        if (size == 0) {
            this.head = newNode;
        } else if (size == 1) {
            this.end = this.head;
            this.head = newNode;
            head.setNext(this.end);
            end.setPrevious(this.head);
        } else {
            newNode.setNext(this.head);
            head.setPrevious(newNode);
            this.head = newNode;
        }
        this.size++;
    }

    /**
     * Will add a value to the end of the linked list
     *
     * @postcondition: the private variable end will now point to a node consisting
     * of the passed value, and the size will increase by one.
     * @param value: the value to be added to the end of the list.
     */
    public void addLast(E value) {
        add(value);
    }

    /**
     * Removes value at the given index of the list and returns it.
     *
     * @precondition: 0 <= index < size
     * @postcondition: node at index will be removed from the list and the pointers
     * will be reset to link the list, and the size will be reduced by one.
     * @param index: the index of the element to remove.
     * @return: the previous value at the index.
     */
    public E remove(int index) {
        E oldValue = get(index);
        DoubleNode oldNode = getNode(index);
        if (index == 0) {
            DoubleNode node = head.getNext();
            if (node != null) {
                node.setPrevious(null);
                head.setNext(null);
            }
            this.head = node;
        } else if (index == size-1) {
            DoubleNode node = end.getPrevious();
            node.setNext(null);
            end.setPrevious(null);
            this.end = node;
        } else {
            DoubleNode previousNode = oldNode.getPrevious();
            DoubleNode nextNode = oldNode.getNext();
            previousNode.setNext(nextNode);
            nextNode.setPrevious(previousNode);
        }
        this.size--;
        return oldValue;
    }

    /**
     * Remove the first element the list.
     *
     * @postcondition: the first value of the list will be removed and all the following
     * values will be shifted left, and the size of the list will decrese by one.
     * @return: the old first element in the list.
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * Remove the last element the list.
     *
     * @postcondition: the last value of the list will be removed and the size of the list
     * will decrease by one
     * @return: the old last element in the list.
     */
    public E removeLast() {
        return remove(this.size-1);
    }


    /**
     * Return the size of the list.
     *
     * @return: the size of the list.
     */
    public int size() {
        return this.size;
    }

    /**
     * Returns a new DoublyLinkedListIterator for the current list.
     *
     * @return: An instance of a DoublyLinkedListIterator to traverse the list
     */
    public Iterator<E> iterator() {
        return new DoublyLinkedListIterator();
    }

    /**
     * A private class to iterate through the linked list and access the values stored
     * in the list. Only able to traverse forwards (not backwards).
     */
    private class DoublyLinkedListIterator implements Iterator<E> {

        private DoubleNode nextNode;
        private final int currentSize;

        /**
         * Will create an instance of the iterator for the linked list. Sets nextNode to
         * the first node in the list, and size to the current size in order to be able to 
         * check if the list has been modified or not.
         */
        public DoublyLinkedListIterator() {
            this.nextNode = head;
            this.currentSize = size;
        }

        /**
         * Will return whether or not the iterator has a next element to point to (there are more
         * values to traverse in the list).
         *
         * @return: true if there are more values, and false if there are no more.
         */
        public boolean hasNext() {
            return (this.nextNode != null);
        }

        /**
         * Will return the next value to point to in the list. Will check if the list has been modified
         * by checking if the size of the list has changed. First confirms that there is another value
         * in the list by only continuing if hasNext() is true.
         *
         * @throws: runtime exepction if the list has been modified.
         * @return: the next value of the list or null if the end of the list has been reached.
         */
        public E next() {
            if (hasNext()) {
                if (this.currentSize==size) {
                    E value = (E) nextNode.getValue();
                    this.nextNode = nextNode.getNext();
                    return value;
                } else {
                    throw new RuntimeException("List has been modified. This iterator is no longer valid");
                }
            }
            return null;
        }

        /**
         * Will remove the current element pointed to by the iterator, and updates the pointers.
         *
         * @postcondition: the element will be removed from the list and the size will decrease by one.
         */
        public void remove() {
            if (nextNode != null && nextNode.getPrevious() != null) {
                DoubleNode previous = nextNode.getPrevious().getPrevious();
                nextNode.setPrevious(previous);
                if (previous != null) {
                    previous.setNext(nextNode);
                }
                size--;
            }
        }

    }

}
