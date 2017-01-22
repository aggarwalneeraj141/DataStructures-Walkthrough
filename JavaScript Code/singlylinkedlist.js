/*
* Implementation of a Singly Linked List in Javascript.
* Has a head node, as well as a size variable.
*
* @constructor
*/
function SinglyLinkedList() {
	this.head = null;
	this.size = 0;
}

/*
* Will add a value to the end of the linked list by
* creating a node with the given value, and linking it
* from the last node in the list.
*
* @param {Object} value: the value to add to the list
*/
SinglyLinkedList.prototype.add(value) {
	var node = new Node(value);
	if (this.head == null)
	{
		head = node;
	} else {
		var temp = this.head;
		while (temp.hasNext())
		{
			temp = temp.getNext();
		}
		temp.setNext(node);
	}
	this.size++;
}

/*
* Will get the node at the respective index in the list.
* If position does not exist, will return null.
* Simply iterates through the nodes in the list the given
* number of times and will return the node at that position.
*
* @param {integer} index: the index of the node to retrieve in the list
* @return: the node at the given position in the list, or null
* if it doesn't exist
*/
SinglyLinkedList.prototype.getNode(index) {
	var node = this.head;
	if (this.head==null || position >= this.size)
	{
		return null;
	}
	for (int i = 0; i < index; i++)
	{
		node = node.getNext();
	}
	return node;
}

/*
* Retrieves the value at the respective index in the list.
* Simply calls getNode to retrieve the node at that position,
* and returns the value of the node. If position doesn't
* exist, then it will return null.
*
* @param {integer} index: the index of the value to retrieve in the list.
* @return: the respective value in the list, or null if the position
* doesn't exist.
*/
SinglyLinkedList.prototype.get(index) {
	var node = getNode(index);
	if (node == null)
	{
		return null;
	} else {
		return node.getValue();
	}
}

/*
* Changes the value in a specific position in the list and
* returns the old value.
*
* @param {integer} index: the index of the value to change in the list.
* @param {Object} value: the new value to replace the old value
* @return: the old value in the position.
*/
SinglyLinkedList.prototype.set(index, value) {
	var oldValue = get(index);
	getNode(index).setValue(value);
	return oldValue;
}

/*
* Will remove a value from the list at the respective position.
* First, it will check if the value being removed is the first.
* If it is, then the head will be set to the next value being pointed
* to from the head.
* If it is not, it will check if it the last value in the list. If it
* is, then it will set the second to last node's next value to null.
* If not, then the previous node's next value will be set to the node
* after the one being removed.
*
* @param {integer} index: the index of the value being removed
* @return: the old value at that index
*/
SinglyLinkedList.prototype.remove(index) {
	var oldValue = get(index);
	if (index == 0) //first node
	{
		this.head = this.head.getNext();
	}
	else if (index == this.size -1) //last node
	{
		getNode(index-1).setNext(null);
	}
	else
	{
		getNode(index-1).setNext(getNode(index+1));
	}
	this.size--;
	return oldValue;
}

/*
* Will return the size of the linked list.
*
* @return: the size of the linked list.
*/
SinglyLinkedList.prototype.size() {
	return this.size;
}
