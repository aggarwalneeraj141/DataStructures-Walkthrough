/*
* Implementation of a node in Javascript. Carries
* a data element, and points to another node. 
*
* @param data: the data element to be stored.
*/
function Node(data) {
	this.data = data;
	this.next = null;
}