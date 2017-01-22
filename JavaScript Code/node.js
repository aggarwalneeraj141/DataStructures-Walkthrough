/*
* Implementation of a node in Javascript. Carries
* a value element, and points to another node.
*
* @constructor
* @param value: the value element to be stored.
*/
function Node(value) {
	this.value = value;
	this.next = null;
}

/*
* Will return the value of the node.
*
* @return the value the node carries.
*/
Node.prototype.getValue(){
	return this.value;
}

/*
* Will change the value of the node and return the
* old value.
*
* @param newValue: the new value to be carried by the node.
* @return the old value of the node.
*/
Node.prototype.setValue(newValue){
	var oldValue = this.value;
	this.value = newValue;
	return oldValue;
}

/*
* Will return if the node points to another node.
*
* @return true if it points to another node and false if not.
*/
Node.prototype.hasNext(){
	return (!this.next==null);
}

/*
* Will return the node being pointed to if its not empty.
*
* @return the node that this node points to if not empty,
* otherwise null.
*/
Node.prototype.getNext(){
	var n = null;
	if (this.hasNext())
	{
		n = this.next;
	}
	return n;
}

/*
* Will update the node being pointed to and return the old one.
*
* @param node: the new node to point to.
* @return the old node.
*/
Node.prototype.setNext(newNext){
	var oldNext = this.next;
	this.next = newNext;
	return oldNext;
}
