/*
* Implementation of a node in Javascript. Carries
* a data element, and points to another node. 
*
* @constructor
* @param data: the data element to be stored.
*/
function Node(data) {
	this.data = data;
	this.next = null;
}

/*
* Will return the data of the node.
*
* @return the data the node carries.
*/
Node.prototype.getData(){
	return this.data;
}

/*
* Will change the data of the node and return the
* old data.
*
* @param newData: the new data to be carried by the node.
* @return the old data of the node.
*/
Node.prototype.setData(newData){
	var oldData = this.data;
	this.data = newData;
	return oldData;
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
	this.next = newNext();
	return oldNext;
}