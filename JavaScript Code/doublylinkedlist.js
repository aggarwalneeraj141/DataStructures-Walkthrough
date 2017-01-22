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

DoublyLinkedList.prototype.getFirst() {
	if (this.head != null) {
		return this.head.getValue();
	}
	return null;
}

DoublyLinkedList.prototype.getLast() {
    if (this.end != null) {
        return end.getValue();
    }
    return null;
}

DoublyLinkedList.prototype.set(index, newValue) {
	var oldValue = get(index);
	getNode(index).setValue(newValue);
	return oldValue;
}

DoublyLinkedList.prototype.add(val) {
	    var newNode = new DoubleNode(value);
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

DoublyLinkedList.prototype.add(index, value) {
	    var newNode = new DoubleNode(value);
        var oldNode = getNode(index);
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

DoublyLinkedList.prototype.addFirst(value){
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

DoublyLinkedList.prototype.addLast(value) {
	add(value);
}

DoublyLinkedList.prototype.remove(index) {
	    var oldValue = get(index);
        var oldNode = getNode(index);
        if (index == 0) {
            var node = head.getNext();
            if (node != null) {
                node.setPrevious(null);
                head.setNext(null);
            }
            this.head = node;
        } else if (index == size-1) {
            var node = end.getPrevious();
            node.setNext(null);
            end.setPrevious(null);
            this.end = node;
        } else {
            var previousNode = oldNode.getPrevious();
            var nextNode = oldNode.getNext();
            previousNode.setNext(nextNode);
            nextNode.setPrevious(previousNode);
        }
        this.size--;
        return oldValue;
}

DoublyLinkedList.prototype.removeFirst() {
	return remove(0);
}

DoublyLinkedList.prototype.removeLast() {
	return remove(this.size-1);
}

DoublyLinkedList.prototype.size() {
	return this.size;
}




