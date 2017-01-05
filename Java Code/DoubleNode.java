/**
 * Implementation of a double node in Java. Carries
 * a value, and points to two other nodes.
 */

public class DoubleNode {

    private Object value;
    private DoubleNode previous;
    private DoubleNode next;

    /**
     * Constructor for DoubleNode. Takes in a value to be stored,
     * and sets previous and next pointers to null.
     *
     * @param val: the value to be assigned.
     */
    public DoubleNode(Object val) {
        this.value = val;
        previous = null;
        next = null;
    }

    /**
     * Returns the value that is stored by the node.
     *
     * @return the value of the node.
     */
    public Object getValue(){
        return this.value;
    }

    /**
     * Returns the pointer of the next DoubleNode.
     *
     * @return the node being pointed to by self in front.
     */
    public DoubleNode getNext(){
        return this.next;
    }

    /**
     * Returns the pointer of the previous DoubleNode.
     *
     * @return the node being pointed to by self behind.
     */
    public DoubleNode getPrevious(){
        return this.previous;
    }


    /**
     * Sets the node's value, and returns the previous value.
     *
     * @param newValue: the new value to be carried by the node.
     * @return the old value of the node, and null if there is none.
     */
    public Object setValue(Object newValue) {
        Object oldValue = this.value;
        this.value = newValue;
        return oldValue;
    }

    /**
     * Sets the next node being pointed to, and returns the old one.
     *
     * @param newNext: the new node to be pointed to
     * @return the old next, and null if there was no value.
     */
    public DoubleNode setNext(DoubleNode newNext) {
        DoubleNode oldNext = this.next;
        this.next = newNext;
        return oldNext;
    }

    /**
     * Sets the previous node being pointed to, and returns the old one.
     *
     * @param newPrevious: the new node to be pointed from
     * @return the old previous, and null if there was no value.
     */
    public DoubleNode setPrevious(DoubleNode newPrevious) {
        DoubleNode oldPrevious = this.previous;
        this.previous = newPrevious;
        return oldPrevious;
    }

}
