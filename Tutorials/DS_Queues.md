# Data Structures - Queues

## What is a Queue?

A queue is another linear data structure that is also used extensively in
project development. It is alongside stack for the most used data structures in web
development. Unlike stacks, however, it uses a FIFO method of storing data, which
means first in, first out.

Imagine a factory line. There are a row of products going down the line and
getting different pieces assembled at each station. The first product to go onto the
line will be the first product to be fully completed at the end of the line. This is an
example of how a queue works: first one in is the first one out.

Queues are vastly implemented throughout projects. For example, imagine a
texting application which allows you to communicate with another user. The catch
is, however, there is a limit on how many messages is stored in the thread.
Naturally, the newest part of the conversation is going to be saved, with the oldest
being deleted. The first ever message that was sent is now the first one to be
deleted. This is an example of how a queue is implemented to directly impact a
user. It’s important to understand the concept of a queue and be able to
implement and apply it to a given situation.

## Queue Manipulation

In order to use a queue, you have to be able to add, access, and remove
the elements in the stack. In addition, there should be a method to return the size
of the queue, check if is empty, and to clear the queue.

## Queue Implementation

Like stacks, we will use an array as the underlying data structure for a queue
because its size can be changed after its declaration, unlike in many other
languages. Here is the constructor for the Queue class:

```javascript
function Queue() {
  this.data=[];
}
```

To add the element passed as a parameter to the queue, we will use the
`enqueue(data_item)` function for the Queue.

```javascript
Queue.prototype.enqueue = function(data_item) {
  this.data.push(data_item);
};
```

To view the element at the end of the queue without removing it, we will implement
the `peek()` function. This will be similar to the stack implementation, in which we
will first define a variable `peekData` to `null`, and then check if the array is empty.
If not, then it will set the variable to the first element in the array and then return it.

```javascript
Queue.prototype.peek = function() {
  var peekData = null;
  if (this.data.length !=0)
  {
    peekData = this.data[0];
  }
  return peekData;
};
```

To remove the first element in the queue and return it, we will use the `dequeue()`
method. It uses the same idea as `peek()`, except will `shift()` the array and thus
remove the element instead of simply returning it.

```javascript
Queue.prototype.dequeue = function() {
  var peekData = null;
  if (this.data.length !=0)
  {
    peekData = this.data.shift();
  }
  return peekData;
};
```

We will utilize the array’s inherit property of `.length` to return the size of the
queue.

```javascript
Queue.prototype.getSize = function() {
  return this.data.length;
};
```

To check if the queue is empty, we just need to check if the size of the array is 0.

```javascript
Queue.prototype.isEmpty = function() {
  return (this.data.length==0);
};
```

To clear the queue, we will just data to an empty array.

```javascript
Queue.prototype.clear = function() {
  this.data = [];
};
```

For the full implementation of a queue (with documentation), check the Javascript Code folder.
