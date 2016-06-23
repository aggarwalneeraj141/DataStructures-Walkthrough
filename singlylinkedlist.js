/*
*
*/
function SinglyLinkedList() {
	this.head = null;
	this.size = 0;
}

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

