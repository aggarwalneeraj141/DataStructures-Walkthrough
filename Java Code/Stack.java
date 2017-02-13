import java.util.Collection;

/**
 * Simple stack class using singly linked nodes.
 * Has the same methods as Java 7's API docs' for
 * a generic stack, and provides similar functionality.
 */
public class Stack<T> {
	private Node top; //top node of the stack
	/*
	 * You could also have a bottom instance variable, but for the
	 * sake of conforming to the idea of a stack in its purest form
	 * it is disregarded here, regardless of efficiency.
	 */
	
	/**
	 * Create's an empty stack.  Top is null. (to create
	 * a stack with an empty node, call value argument
	 * constructor with a null value).
	 */
	public Stack(){
		
	}
	/**
	 * Initialize a stack with a single node
	 * @param init represents the value we initialize the stack with.
	 */
	public Stack(T init){
		top = new Node(init);
	}
	/**
	 * Creates a stack from a given collection of items.  A collection
	 * can be a list, a queue, etcetera from Java's API.  The first item
	 * will go the top of the stack, while the last item will go to the bottom,
	 * etctera...
	 * @param ls the collection we convert into this stack.
	 */
	public Stack(Collection<T> ls){
		Object[] ar = ls.toArray();
		Node _top = new Node(ar[0]);
		top = _top; //set pointer to the initial, which is the top
		for(int i = 1; i < ar.length; i++){
			_top.setNext(new Node(ar[i]));
			_top = _top.getNext();
		}
	}
	/**
	 * @return true if the stack is empty; otherwise, false.
	 */
	public boolean isEmpty(){
		return top == null;
	}
	/**
	 * @return the top node's value;
	 */
	@SuppressWarnings("unchecked")
	public T peek(){
		if(top == null) return null;
		return (T)top.getValue();
	}
	/**
	 * Remove the top node and return its value;
	 * @return the top value.
	 */
	public T pop(){
		if(top == null) return null;
		T _top = peek();
		top = top.getNext();
		return _top;
	}
	/**
	 * Add a node to the top of the stack.
	 * @param item represents the value we add.
	 * @return nd
	 */
	public Node push(T item){
		Node nd = new Node(item);
		nd.setNext(top);
		top = nd;
		return nd;
	}
	/**
	 * 
	 * @return the distance from the top of the stack at which
	 * the first instance of nd, where the top of the stack is
	 * counted as being a distance of 1 away.  Node comparison
	 * is done using its equals method.  If the node is not
	 * present it outputs -1.  Inputing null will give you the
	 * "length" of the stack.
	 * @param item represents the value we are searching for
	 * @return the distance from the top of the stack of nd;
	 * if not present return -1.
	 */
	public int search(T item){
		Node _top = top; //"top" of "substack"
		int it = 1;
		//this case is effectivelly the length of the stack +1
		if(item == null){
			while(_top != null){
				_top = _top.getNext();
				it++;
			}
			return it;
		}
		else{
			while(_top != null){
				if(_top.getValue().equals(item))
					return it;
				it++;
				_top = _top.getNext();
			}
			return -1;
		}
	}
	/**
	 * @return a string representation of the queue/stack.
	 */
	@Override
	public String toString(){
		if(isEmpty()) return "[]";
		else{
			String str = "";
			Node nd = top;
			while(nd != null){
				str += nd.getValue() + ", ";
				nd = nd.getNext();
			}
			return str.substring(0, str.length()-2);//ignore last ", "
		}
	}
	/**
     * @return true if two stacks are equal (have the same
     * values in the same order).  Note, this will return false if
     * st is not a stack.
     * @param st represents the stack we are comparing to
     * @precondition if st is a stack, its type parameter is the same
     * as this stack.
     */
    @SuppressWarnings("unchecked")
	@Override
    public boolean equals(Object st){
    	if(st == null || !(st instanceof Stack)) 
    		return false;
    	else{
    		return nodesEqual(top,((Stack<T>)st).top);
    	}
    }
    //helpful method
    private boolean nodesEqual(Node a, Node b){
    	if(a == null){
    		return b == null;
    	}
    	if(b == null){
    		return a == null;
    	}
    	if(!a.getValue().equals(b.getValue()))
    		return false;
    	else
    		return nodesEqual(a.getNext(),b.getNext());
    }
}
