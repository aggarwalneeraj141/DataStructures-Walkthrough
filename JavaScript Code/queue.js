/*
* This class is a Queue implementation in Javascript.
* @constructor
*/
function Queue() {
	this.data=[];
}

/*
* Add an element to the end of the queue.
*
* @param data_item: the element to be added to the end of the queue.
*/
Queue.prototype.enqueue = function(data_item) {
	this.data.push(data_item);
};

/*
* Remove and return the first element (provided the queue is not empty).
* If the queue is empty, the method will return null.
*
* @return: null if the queue is empty, otherwise the first element.
*/
Queue.prototype.dequeue = function() {
	var peekData = null;
	if (this.data.length !=0)
	{
		peekData = this.data.shift();
	}
	return peekData;
};

/*
* Return the first element of the queue without removing it (provided
* the queue is not empty). If it is, then the method will return null.
* 
* @return: null if the queue is empty, otherwise the first element.
*/
Queue.prototype.peek = function() {
	var peekData = null;
	if (this.data.length !=0)
	{
		peekData = this.data[0];
	}
	return peekData;
};

/*
* Will return the number of elements in the queue.
*
* @return: the number of elements in the queue.
*/
Queue.prototype.getSize = function() {
	return this.data.length;
};

/*
* Will return a boolean representing if the queue is empty or not.
*
* @return: true if the queue is empty, otherwise false.
*/
Queue.prototype.isEmpty = function() {
	return (this.data.length==0);
};

/*
* Will reset the queue by removing all elements.
*/
Queue.prototype.clear = function() {
	this.data = [];
};