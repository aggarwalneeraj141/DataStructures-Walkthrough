# Data Structures - Nodes

## What is a Node?

Imagine a Node as a packet of information. It only carries the value of data given to it, as well as a reference to another node. This functionality alone (with minor extensions) is enough to build larger data structures such as linked lists and trees. A node is the building block for larger data structures, which are widely implemented in the industry.

## Node Manipulation

As stated above, a node only has two attributes – the data value and the node it points to. When a node is initialized, it must carry a data value, but not the node pointer. Thus we must have a `hasNode()` function to check if there is a node value. We don’t need this for the data value, since we know that a node cannot be created without the data. Otherwise, it’s the basic functions of retrieving and setting the values for the node. Although we could directly access the variables of the node class, this is noted as bad practice and thus we will create accessor methods in order to manipulate the data of the node.

## Node Implementation

To begin, lets define the node constructor. It only has the data, and the node that it points to. Remember that a node must be initialized with the data it will carry.

```javascript
function Node(data) {
  this.data = data;
  this.next = null;
}
```

Now, to retrieve the data, we will create a `getData()` method that returns the method of the variable. To change the data, we will create a `setData()` method to change the value of the data. This, however, will also return the old value of the node. Again, we are creating these methods to avoid bad practice in programming.

```javascript
Node.prototype.getData() {
  return this.data;
}

Node.prototype.setData(newData) {
  var oldData = this.data;
  this.data = newData;
  return oldData;
}
```

Next, we have to manipulate the node. We will check if there is a node stored with `hasNext()`. If there is a node stored, then `getNext()` will return the node. Otherwise, it will return null. To change the node being stored, we used `setNext()`, which will return the old node being stored.

```javascript
Node.prototype.hasNext() {
  return (!this.next==null);
}

Node.prototype.getNext() {
  var n = null;
  if (this.hasNext())
  {
    n = this.next;
  }
  return n;
}

Node.prototype.setNext(newNext) {
  var oldNext = this.next;
  this.next = newNext();
  return oldNext;
}
```

For the full implementation, check out the Javascript code folder.
