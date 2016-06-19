/*
*
*/
function Stack() {
	this.data={};
	this.size=0;
}

/*
*
*/
Stack.prototype.push = function(data_item) {
	this.data[this.size] = data_item;
	this.size++;
};

/*
*
*/
Stack.prototype.pop = function() {
	var poppedData = null;
	if (this.size != 0)
	{
		this.size--;
		poppedData = this.data[this.size];
		delete this.data[this.size];
	}
	return poppedData;
};

/*
*
*/
Stack.prototype.peek = function() {
	var peekData = null;
	if (this.size !=0)
	{
		peekData = this.data[this.size];
	}
	return peekData;
};

/*
*
*/
Stack.prototype.size = function() {
	return this.size;
};

/*
*
*/
Stack.prototype.isEmpty = function() {
	return (this.size == 0);
};

/*
*
*/
Stack.prototype.clear = function() {
	this.data = {};
	this.size = 0;
};