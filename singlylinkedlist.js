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

/**
* Will add a value to the end of the linked list.
*
* @param data_element: the data to add to the list.
*/
SinglyLinkedList.prototype.add(data_element) {
	var node = new Node(data_element);
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
* FINISH COMMENTING
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

SinglyLinkedList.prototype.get(index) {
	var node = getNode(index);
	if (node == null)
	{
		return null;
	} else {
		return node.getData();
	}
}

/*
* Reset the value of the respective node.
*/
SinglyLinkedList.prototype.set(index, value) {
	var oldValue = get(index);
	getNode(index).setData(value);
	return oldValue;
}

SinglyLinkedList.prototype.size() {
	return this.size;
}

