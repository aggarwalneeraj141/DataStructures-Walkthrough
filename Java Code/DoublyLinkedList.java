/**
 * Implementation of a Doubly Linked List in Java.
 * Has a head node, end node, as well as a size variable.
 */
public class DoublyLinkedList {

    private DoubleNode head;
    private DoubleNode end;
    private int size;

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
        for (int i = 0; i < index; i++) {current = current.getNext();}
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
        for (int i = this.size-1; i > index; i--) {current = current.getPrevious();}
        return current;
    }

    /**
     * get node at index in linkedlist. based on location, it will
     * iterate from front or back.
     * @param index: the index of the node to get.
     * @return: the node at the specific index.
     */
    //private because only deal with actual values
    private DoubleNode getNode(int index) {
        if (index > this.size/2) {return getNodeFromLast(index);}
        return getNodeFromFirst(index);
    }


    /**
     * gets the value of the node at the index.
     * @param index: the index of which to retrieve the value.
     * @return: the value of the node.
     */
    public Object get(int index) {
        return getNode(index).getValue();
    }

    /**
     * Set the value of the node at the specified index, returning
     * the old value at that index.
     *
     * @param index: the index of which to set the value.
     * @param newValue: the new value to be set.
     * @return: the old value.
     */
    public Object set(int index, Object newValue) {
        Object oldValue = get(index);
        getNode(index).setValue(newValue);
        return oldValue;
    }

    //adds value to the end

    /**
     * adds the value to the end of the linked list.
     *
     * @param val: the value to be added to the end of the list.
     */
    public void add(Object val) {
        DoubleNode node = new DoubleNode(val);
        if (this.size == 0) {this.head = node;}
        else if (this.size == 1) {
            this.end = node;
            head.setNext(this.end);
            end.setPrevious(this.head);
        } else {
            end.setNext(node);
            node.setPrevious(end);
            this.end = node;
        }
        this.size++;
    }

    //still to implement - remove, add (at index), addFirst, addLast,

    /**
     * return the size of the list.
     * @return: the size of the list.
     */
    public int size() {
        return this.size;
    }

}
