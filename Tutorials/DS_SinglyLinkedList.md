# Data Structures - Singly Linked List

## What is a Singly Linked List?
Linked lists is one of the most taught data structures in computer science. Essentially, it is a collection of nodes that each hold a data value of the same kind, and points to another node. Singly means that the nodes are only connected one way, and you can’t go backwards in the list – only forward.

## Singly Linked List Manipulation
We need to be able to add to the list, delete from the list, and change data in the list. We will do this by having multiple functions that will retrieve the specified node or value by the index. We will do this iteratively, always starting from the front of the list. In addition, it would be nice to retrieve the size of the list.

## Singly Linked List Implementation
The first thing that we have to do is create the constructor for the list, which consists of the head `node` of the list as well as the recorded size of the list.

```javascript
function SinglyLinkedList() {
  this.head = null;
  this.size = 0;
}
```
Now, we need to be able to add elements to our list with the `add(data_element)` function. We will simply do this by first checking if the list is empty. If it is, then we will create a new node and set it as the head. If not, then we will iterate through the
nodes to the last node, and set its next value to a new node carrying the passed value.

```javascript
SinglyLinkedList.prototype.add(data_element) {
  var node = new Node(data_element);
  if (this.head == null)
  {
    head = node;
  } else {
    var temp = this.head;
    while (temp.hasNext())
    {
      temp = temp.getNext();
    }
    temp.setNext(node);
  }
  this.size++;
}
```
Now that we can add elements to the list, we have to be able to retrieve nodes from the list with `getNode(index)`. Note that this is a helper function for retrieving actual values, as well as streamlining the ease of use. We simply verify that the position exists in the list, and if it doesn’t then it will return `null`. Otherwise, we will return the node at that index.

```javascript
SinglyLinkedList.prototype.getNode(index) {
  var node = this.head;
  if (this.head==null || position >= this.size)
  {
    return null;
  }
  for (int i = 0; i < index; i++)
  {
    node = node.getNext();
  }
  return node;
}
```
Now that we can retrieve a node at the specific index, we will be able to retrieve the value at that specific index in the list by simply calling the function we just implemented, and returning the value it holds through the function `get(index)`.

```javascript
SinglyLinkedList.prototype.get(index) {
  var node = getNode(index);
  if (node == null)
  {
    return null;
  } else {
    return node.getData();
  }
}
```
Now that we can retrieve the values based on index position, we should also be able to change the values in the list through index position with `set(index, value)`. We simply do this by changing the data that the node is holding, again calling the `getNode(index)` function.

```javascript
SinglyLinkedList.prototype.set(index, value) {
  var oldValue = get(index);
  getNode(index).setData(value);
  return oldValue;
}
```
Now that we can add, retrieve, and set, we just need to be able to delete a value from the list with `remove(index)`. There are three cases that we need to consider. First, if the value being removed is the first. If it is, then we will simply set the second node in the list as the head. The second condition we need to check for is if it is the last value in the list. In this case, we just set the second to last node in the list to point to null. Lastly, if it is somewhere in the middle of the list, then we will set the node in front of the node being removed to point to the node after, such that it skips over the one being removed.

```javascript
SinglyLinkedList.prototype.remove(index) {
  var oldValue = get(index);
  if (index == 0) //first node
  {
    this.head = this.head.getNext();
  }
  else if (index == this.size -1) //last node
  {
    getNode(index-1).setNext(null);
  } else {
    getNode(index-1).setNext(index+1);
  }
  this.size--;
  return oldValue;
}
```
The last thing we need to do is have a `size()` return the size of the linked list. We will simply return `this.size`. Again, we avoid pulling the direct variable as it is considered bad practice.

```javascript
SinglyLinkedList.prototype.size() {
  return this.size;
}
```
For the full implementation of a singly linked list (with documentation), check the Javascript Code folder.
