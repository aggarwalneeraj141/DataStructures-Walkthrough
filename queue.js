/*
* This class is a Queue implementation in Javascript.
* @constructor
*/
function Queue() {
	this.data=[];
}

Queue.prototype.enqueue = function(data_item) {
	this.data.push(data_item);
};

Queue.prototype.dequeue = function() {
	var peekData = null;
	if (this.data.length !=0)
	{
		peekData = this.data.shift();
	}
	return peekData;
};

Queue.prototype.peek = function() {
	var peekData = null;
	if (this.data.length !=0)
	{
		peekData = this.data[0];
	}
	return peekData;
};

Queue.prototype.getSize = function() {
	return this.data.length;
};

Queue.prototype.isEmpty = function() {
	return (this.data.length==0);
};

Queue.prototype.clear = function() {
	this.data = [];
};