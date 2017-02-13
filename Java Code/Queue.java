import java.util.Collection;

/**
 * A simple queue class.
 */
public class Queue<E> {
	private Node back; //back of the queue
	//think of it as a line of people waiting for icecream or something
	
	//we could have a front pointer, but it is unecessary
	
	/**
	 * Create an empty queue with null references.
	 */
	public Queue(){
		
	}
	/**
	 * Create a queue with one item.
	 * @param init represents the item we
	 * begin with.
	 */
	public Queue(E init){
		Node _nd = new Node(init);
		back = _nd;
	}
	/*
	 * Create a queue from a collection of Es.
	 * @param ls is the collection we create this queue
	 * from.  (first item will go to the back, last
	 * to the front, etc...)
	 */
	public Queue(Collection<E> ls){
		Object[] ar = ls.toArray();
		Node _back = new Node(ar[0]);
		back = _back; //set pointer to the initial, which is the top
		for(int i = 1; i < ar.length; i++){
			_back.setNext(new Node(ar[i]));
			_back = _back.getNext();
		}
	}
	/**
	 * @return whether the queue is empty.
	 */
	public boolean isEmpty() {
		return back == null;
	}
	/**
	 * Add item to the queue (at its tail/back).
	 * @param item represents the item we will add.
	 * @return true if we successfully add.
	 */
	public boolean add(E item){
		Node nd = new Node(item);
		nd.setNext(back);
		back = nd;
		return true;
	}
	/**
	 * Remove the head of the queue.  Return null if the queue is empty.
	 * @return the item we remove. (null if empty)
	 */
	@SuppressWarnings("unchecked")
	public E remove(){
		if(back == null) return null;
		if(back.getNext() == null){
			back = null;
			return null;
		}
		Node nd = back;
		while(!(nd.getNext().getNext() == null)){
			nd = nd.getNext();
		}
		Node _nd = nd.getNext();
		nd.setNext(null);
		return (E)_nd.getValue();//value at the front
	}
	/**
	 * @return the head (front) of the queue.
	 */
	@SuppressWarnings("unchecked")
	public E peek(){
		if(isEmpty()) return null;
		if(back.getNext() == null) return (E)back.getValue();
		else{
			Node _back = back;
			while(!(_back.getNext() == null)){
				_back=_back.getNext();
			}
			return (E) _back.getValue();
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
			Node nd = back;
			while(nd != null){
				str += nd.getValue() + ", ";
				nd = nd.getNext();
			}
			return str.substring(0, str.length()-2);//ignore last ", "
		}
	}
	/**
	 * @return true if two queues have all the same values at the
	 * same positions.
	 * It turns out that since we used the same linked list type structure
	 * as the stack this is the exact same code.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object q){
    	if(q == null || !(q instanceof Queue)) 
    		return false;
    	else{
    		return nodesEqual(back,((Queue<E>)q).back);
    	}
    }
	//helpful method
    private boolean nodesEqual(Node a, Node b){
    	if(a == null && b == null) return true;
    	if(((a == null) && !(b == null)) || ((b == null) && ! (a == null)))
    		return false;
    	if(!a.equals(b))
    		return false;
    	return nodesEqual(a.getNext(),b.getNext());
    }
	//for queue purity
	public void enqueue(E t){
		add(t);
	}
	public E dequeue(){
		return remove();
	}
}
