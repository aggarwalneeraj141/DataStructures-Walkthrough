/*
* This class is a stack implementation in Javascript.
* @constructor
*/
function Stack() {
	this.data=[];
}

/*
* Add an element to the top of the stack.
*
* @param data_item: the element to be added to the top of the stack.
*/
Stack.prototype.push = function(data_item) {
	this.data.push(data_item);
};

/*
* Remove and return the top element (provided the stack is not empty).
* If the stack is empty, the method will return null.
*
* @return: null if the stack is empty, otherwise the top element.
*/
Stack.prototype.pop = function() {
	var poppedData = null;
	if (this.data.length != 0)
	{
		poppedData = this.data[this.data.length-1];
		this.data.splice(this.data.length-1, 1);
	}
	return poppedData;
};

/*
* Return the top element of the stack without removing it (provided
* the stack is not empty). If it is, then the method will return null.
* 
* @return: null if the stack is empty, otherwise the top element.
*/
Stack.prototype.peek = function() {
	var peekData = null;
	if (this.data.length !=0)
	{
		peekData = this.data[this.data.length-1];
	}
	return peekData;
};

/*
* Will return the number of elements in the stack.
*
* @return: the number of elements in the stack.
*/
Stack.prototype.getSize = function() {
	return this.data.length;
};

/*
* Will return a boolean representing if the stack is empty or not.
*
* @return: true if the stack is empty, otherwise false.
*/
Stack.prototype.isEmpty = function() {
	return (this.data.length == 0);
};

/*
* Will reset the stack by removing all elements and setting size to 0.
*/
Stack.prototype.clear = function() {
	this.data = [];
};