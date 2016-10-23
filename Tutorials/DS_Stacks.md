# Data Structures - Stacks

## What is a Stack?

A stack is a linear data structure that is used extensively in project
development for its retention of sequential order. It is one of the most used data
structures in web development, next to queues. It uses a LIFO method of storing
data, meaning last in, first out.

Imagine you are cleaning your kitchen, and start a stack of plates to be
washed. You put one on top of the pile, and keep adding until you put all of the
plates in the stack. Then, when you start washing it, the one on top (the most
recent plate you put) is the first one to be washed. The pile of plates represents a
stack: the last one you put on top is the first one to be washed.

A stack can be implemented for use of many things, such as the undo
feature when you’re typing. The last words you type are put at the top of the stack,
and if you undo them, they are removed from the top of the stack. Another
example using a stack is the back button in your browser. Every website you visit is
added to the top of the stack, and going to the previous page removes the last
website from the top. These are just a couple of examples of how stacks can be
implemented directly to impact the user. It’s important to understand the concept
of a stack and be able to implement and apply it to a given situation.

## Stack Manipulation

In order to use a stack, you have to be able to add, access, and remove
elements in the stack. In addition, there should be a method to return the size of
the stack, check if it empty, and to clear the stack.

## Stack Implementation

For the stack, we can use an array as the underlying data structure to store
the stack elements. Unlike most languages, you don’t need to decide the absolute
size of an array when declaring. Its size can be changed beyond the declaration.
Here is the constructor for the Stack class:

```javascript
function Stack() {
  this.data=[];
}
```

Now, to add an element, we will add the element passed as a parameter to the
array through the `push(data_item)` function.

```javascript
Stack.prototype.push = function(data_item) {
  this.data.push(data_item);
};
```

To view the element at the top of the stack without removing it, we will have the
`peek()` function. This will first define a variable `peekData` to `null`, and then
check if the array is empty. If not, then it will set the variable to the last element in
the array, and then return it.

```javascript
Stack.prototype.peek = function() {
  var peekData = null;
  if (this.data.length!=0)
  {
    peekData = this.data[this.data.length-1];
  }
  return peekData;
};
```

To remove the top element of the stack and return it, we will use the `pop()`
method. It uses the same idea as `peek()`, except it also deletes the element from
the array if the array size is not 0.

```javascript
Stack.prototype.pop = function() {
  var poppedData = null;
  if (this.data.length!= 0)
  {
    poppedData = this.data[this.data.length-1];
    this.data.splice(this.data.length-1, 1);
  }
  return poppedData;
};
```

Because the array has an inherit `.length` property, we just have to return its value
for the `getSize()` method.

```javascript
Stack.prototype.getSize = function() {
  return this.data.length;
};
```

Similarly, we just have to check if the size of the array is 0 for the `isEmpty()`
method.

```javascript
Stack.prototype.isEmpty = function() {
  return (this.data.length == 0);
};
```

To clear the stack with `clear()`, we just set data as an empty array.

```javascript
Stack.prototype.clear = function() {
  this.data = [];
};
```

For the complete implementation of a stack (with documentation), check ouit the Javascript Code folder.
