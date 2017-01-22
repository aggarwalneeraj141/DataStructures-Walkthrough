/**
 * Implementation of a Doubly Linked List in Java.
 * Has a head node, end node, as well as a size variable.
 *
 * @constructor
 */
function DoublyLinkedList() {
	this.head = null;
	this.end = null;
	this.size = 0;
}

DoublyLinkedList.prototype.getNodeFromFirst(index) {
	var current = this.head;
	for (int i = 0; i<index; i++) {
		current = current.getNext();
	}
	return current;
}

DoublyLinkedList.prototype.getNodeFromLast(index) {
	var current = this.end;
	for (int i = this.size-1; i > index; i--) {
		current = current.getPrevious();
	}
	return current;
}

DoublyLinkedList.prototype.getNode(index) {
	if (index > this.size/2) {
		return getNodeFromLast(index);
	}
	return getNodeFromFirst(index);
}

DoublyLinkedList.prototype.get(index) {
	return getNode(index).getValue();
}

