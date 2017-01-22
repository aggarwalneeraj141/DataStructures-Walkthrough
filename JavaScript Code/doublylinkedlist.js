/*
* Implementation of a Doubly Linked List in Javascript.
* Has a head node, end node, as well as a size variable.
*
* @constructor
*/
function DoublyLinkedList() {
	this.head = null;
	this.end = null;
	this.size = 0;
}

/*
* Get the desired node, iterating from the first node.
*
* @param {integer} index: the index of the node to get.
* @return: the node at the given index.
*/
DoublyLinkedList.prototype.getNodeFromFirst(index) {
	var current = this.head;
	for (int i = 0; i<index; i++) {
		current = current.getNext();
	}
	return current;
}

/*
* Get the desired node, iterating from the last node.
*
* @param {integer} index: the index of the node to get.
* @return: the node at the given index.
*/
DoublyLinkedList.prototype.getNodeFromLast(index) {
	var current = this.end;
	for (int i = this.size-1; i > index; i--) {
		current = current.getPrevious();
	}
	return current;
}

/*
* Get node at index in the list. based on the placement, it will
* iterate from the front or the back of the list to retrieve the value.
*
* @param {integer} index: the index of the node to get.
* @return: the node at the specific index.
*/
DoublyLinkedList.prototype.getNode(index) {
	if (index > this.size/2) {
		return getNodeFromLast(index);
	}
	return getNodeFromFirst(index);
}

/*
* Retrieves the value of the node at the index.
*
* @param {integer} index: the index of which to retrieve the value.
* @return: the value of the node.
*/
DoublyLinkedList.prototype.get(index) {
	return getNode(index).getValue();
}

/*
* Will retrieve the first value in the list.
*
* @return: the first value in the list, or null if the list is empty.
*/
DoublyLinkedList.prototype.getFirst() {
	if (this.head != null) {
		return this.head.getValue();
	}
	return null;
}

/*
* Will retrieve the last value in the list.
*
* @return: the last value in the list, or null if the list is empty.
*/
DoublyLinkedList.prototype.getLast() {
    if (this.end != null) {
        return end.getValue();
    }
    return null;
}

/*
* Set the value of the node at the specified index, returning
* the old value at that index.
*
* @param {integer} index: the index of which to set the value.
* @param {Object} newValue: the new value to be set.
* @return: the old value.
*/
DoublyLinkedList.prototype.set(index, newValue) {
	var oldValue = get(index);
	getNode(index).setValue(newValue);
	return oldValue;
}

/*
* adds the value to the end of the linked list.
*
* @postcondition: the value will be added to the linked list, and the size will increase
* by one.
* @param {Object} value: the value to be added to the end of the list.
*/
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

/*
* Add the value at the selected index and shift all following nodes to the right.
*
* @precondition: 0 <= index < size
* @postcondition: all nodes after the index will be shifted to the right and the size
* of the list will increase by one
* @param {integer} index: the index at which to insert the value
* @param {Object} value: the value to be inserted into the list
*/
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

/*
* Inserts a new value at the front of the list.
*
* @postcondition: the private variable head will now point to a node consisting
* of the passed value, and the size will increase by one.
* @param {Object} value: the value to be inserted at the front of the list
*/
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

/*
* Will add a value to the end of the linked list
*
* @postcondition: the private variable end will now point to a node consisting
* of the passed value, and the size will increase by one.
* @param {Object} value: the value to be added to the end of the list.
*/
DoublyLinkedList.prototype.addLast(value) {
	add(value);
}

/*
* Removes value at the given index of the list and returns it.
*
* @precondition: 0 <= index < size
* @postcondition: node at index will be removed from the list and the pointers
* will be reset to link the list, and the size will be reduced by one.
* @param {integer} index: the index of the element to remove.
* @return: the previous value at the index.
*/
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

/*
* Remove the first element the list.
*
* @postcondition: the first value of the list will be removed and all the following
* values will be shifted left, and the size of the list will decrese by one.
* @return: the old first element in the list.
*/
DoublyLinkedList.prototype.removeFirst() {
	return remove(0);
}


/*
* Remove the last element the list.
*
* @postcondition: the last value of the list will be removed and the size of the list
* will decrease by one
* @return: the old last element in the list.
*/
DoublyLinkedList.prototype.removeLast() {
	return remove(this.size-1);
}

/*
* Return the size of the list.
*
* @return: the size of the list.
*/
DoublyLinkedList.prototype.size() {
	return this.size;
}




