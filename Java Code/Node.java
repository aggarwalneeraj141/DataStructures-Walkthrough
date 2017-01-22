/**
 * Implementation of a double node in Java. Carries
 * a value, and points to two other nodes.
 */

public class Node {

    private Object value;
    private Node next;

    /**
     * Constructor for Node. Takes in a value to be stored,
     * and sets previous and next pointers to null.
     *
     * @param val: the value to be assigned.
     */
    public Node(Object val) {
        this.value = val;
        next = null;
    }

    /**
     * Returns the value that is stored by the node.
     *
     * @return the value of the node.
     */
    public Object getValue() {
        return this.value;
    }

    /**
     * Returns if the Node points to another node.
     *
     * @return: true if next points to a node, and false if
     * next is null.
     */
    public boolean hasNext() {
        return (next != null);
    }

    /**
     * Returns the pointer of the next Node.
     *
     * @return the node being pointed to by self in front.
     */
    public Node getNext() {
        return this.next;
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
    public Node setNext(Node newNext) {
        Node oldNext = this.next;
        this.next = newNext;
        return oldNext;
    }

}
