/**
 * Implementation of a Singly Linked List in Java.
 * Has a head node, as well as a size variable.
 */
public class SinglyLinkedList<E> {

    private Node head;
    private int size;

    public String toString()
    {
        Node node = head;
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
     * Constructor without parameters, which sets head
     * node to null and size to 0.
     */
    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Constructor with a given head value for the
     * linked list, and sets size to 1.
     *
     * @param h: the head value for the linked list.
     */
    public SinglyLinkedList(Node h) {
        this.head = h;
        this.size = 1;
    }

    /**
     * Will add a value to the end of the linked list by
     * creating a node with the given value, and linking it
     * from the last node in the list.
     *
     * @param value: the data to add to the list.
     */
    public void add(E value) {
        Node add = new Node(value);
        if (this.head == null) {
            this.head = add;
        } else {
            Node temp = this.head;
            while (temp.hasNext()) {
                temp = temp.getNext();
            }
            temp.setNext(add);
        }
        this.size += 1;
    }

    /**
    * Will get the node at the respective index in the list.
    * If position does not exist, will return null.
    * Simply iterates through the nodes in the list the given
    * number of times and will return the node at that position.
    *
    * @param index: the index of the node to retrieve in the list
    * @return: the node at the given position in the list, or null
    * if it doesn't exist.
    */
    public Node getNode(int index) {
        Node temp = this.head;
        if (this.head == null || index >= this.size) {
            return null;
        }
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp;
    }

    /**
    * Retrieves the value at the respective index in the list.
    * Simply calls getNode to retrieve the node at that position,
    * and returns the data value of the node. If position doesn't
    * exist, then it will return null.
    *
    * @param index: the index of the value to retrieve in the list.
    * @return: the respective value in the list, or null if the position
    * doesn't exist.
    */
    public E get(int index) {
        Node node = getNode(index);
        if (node == null) {
            return null;
        }
        return (E) node.getValue();
    }

    /**
    * Changes the value in a specific position in the list and
    * returns the old value.
    *
    * @param index: the index of the value to change in the list.
    * @param newValue: the new value to replace the old value
    * @return: the old value in the position.
    */
    public E set(int index, E newValue) {
        E oldValue = get(index);
        getNode(index).setValue(newValue);
        return oldValue;
    }

    /**
     * Will remove a value from the list at the respective position.
     * First, it will check if the value being removed is the first.
     * If it is, then the head will be set to the next value being pointed
     * to from the head.
     *
     * If it is not, it will check if it the last value in the list. If it
     * is, then it will set the second to last node's next value to null.
     * If not, then the previous node's next value will be set to the node
     * after the one being removed.
     *
     * @param index: the index of the value being removed
     * @return: the old value at that index
     */
    public E remove(int index) {
        E oldValue = get(index);
        if (index == 0) {
            this.head = this.head.getNext();
        } else if (index == this.size -1) {
            getNode(index-1).setNext(null);
        } else {
            getNode(index-1).setNext(getNode(index+1));
        }
        this.size--;
        return oldValue;
    }

    /**
     * Will return the size of the linked list.
     *
     * @return: the size of the linked list.
     */
    public int size() {
        return this.size;
    }
}
