import java.util.ArrayList;

/**
 * Tester for: BST, Queue, SimpleMap, Stack.
 * (I know this tester is terrible, but it worked :P)
 */
public class MultiTester {
	public static void testQueue(){
		//note we don't test equals here since it is idental to the stack's
		Queue<String> qq = new Queue<String>();
		System.out.println(qq);
		qq.enqueue("a");
		qq.enqueue("b");
		qq.enqueue("c");
		System.out.println(qq);
		qq.dequeue();
		System.out.println(qq);
		qq.dequeue();
		qq.dequeue();
		qq.dequeue();
		qq.dequeue();
		qq.dequeue();
		System.out.println(qq);
		System.out.println(qq.equals(new Queue<String>()));
		System.out.println(qq.isEmpty());
		qq.enqueue("3");
		System.out.println(qq.isEmpty());
		System.out.println(qq.peek());
		System.out.println(qq.equals(new Queue<String>("3")));
		ArrayList<String> ar = new ArrayList<String>();
		ar.add("4");
		ar.add("3");
		//this functions the same for the stack so we don't retest it
		System.out.println(qq.equals(new Queue<String>(ar)));
		qq.enqueue("4");
		System.out.println(qq.equals(new Queue<String>(ar)));
		qq.dequeue();
		qq.dequeue();
		System.out.println(qq.peek());
		qq.remove();
	}
	public static void testMap(){
		SimpleMap<String,String> shtty = new SimpleMap<String, String>();
		shtty.put("spaghetti", "food");
		shtty.put("spaghetti", "food");
		shtty.put("spaghetti", "food");
		System.out.println(shtty.equals(new SimpleMap<String, String>("spaghetti","food")));
		shtty.put("spaghetti", "food");
		shtty.put("spaghetti", "food");
		shtty.put("spaghetti", "food");
		shtty.put("potato", "other food");
		shtty.put("cookie", "food");
		shtty.put("hat", "not food"); //don't worry I tested multi-add
		System.out.println(shtty.equals(new SimpleMap<String, String>("spaghetti","food")));
		System.out.println(shtty);
		shtty.clear();
		System.out.println(shtty);
		shtty.put("spaghetti", "food");
		shtty.put("spaghetti", "food");
		shtty.put("potato", "other food");
		shtty.put("cookie", "food");
		shtty.put("hat", "not food"); 
		SimpleMap<String,String> oo = shtty.clone();
		System.out.println(oo);
		System.out.println(oo.ContainsValue("not food"));
		System.out.println(oo.ContainsValue("potato"));
		System.out.println(oo.ContainsKey("potato"));
		System.out.println(oo.ContainsKey("aaaaaaaaaaa"));
		System.out.println(oo.equals(shtty));
		shtty.remove("aaa");
		System.out.println(oo.equals(shtty));
		shtty.remove("potato");
		System.out.println(oo.equals(shtty));
		System.out.println(shtty);
		oo.put("aa", null);
		System.out.println(oo.size());
		System.out.println(oo.isEmpty());
		oo.remove("cookie");
		oo.remove("hat");
		oo.remove("spaghetti");
		System.out.println(oo.isEmpty());
	}
	
	public static void testStack(){
		
		Stack<String> st = new Stack<String>();
		System.out.println("st: " + st + " ; is empty: " + st.isEmpty());
		System.out.println("pushing a then b then c");
		st.push("a");
		st.push("b");
		st.push("c");
		System.out.println("st: " + st);
		System.out.println("pop: " + st.pop());
		System.out.println("st: " + st);
		System.out.println("peek: " + st.peek());
		System.out.println("is empty: " + st.isEmpty());
		System.out.println("clearing");
		st.pop();
		st.pop();
		st.pop();
		System.out.println("is empty: " + st.isEmpty());
		System.out.println("peek: " + st.peek());
		System.out.println("searching for 'testing': " + st.search("testing"));
		System.out.println("pushing a then b then c again");
		st.push("a");
		st.push("b");
		st.push("c");
		System.out.println("searching for a should be 3: " + st.search("a"));
		System.out.println("adding another a at the top");
		st.push("a");
		System.out.println("searching for a should be 1: " + st.search("a"));
		System.out.println("searching for 'testing': " + st.search("testing"));
		System.out.println("searching for null should be 5: " + st.search(null));
		System.out.println("filling with numbers");
		for(int i = 0; i < 300; i++){
			st.push("420");
		}
		System.out.println("searching for null, should be 305: " + st.search(null));
		System.out.println("searching for a should be 301: " + st.search("a"));
		System.out.println("st: " + st);
		System.out.println("making a super long stack");
		for(int i = 0; i < 9999; i++){
			st.push("eh");
		}
		System.out.println(st);
		Stack<String> st2 = new Stack<String>();
		st2.push("a");
		st2.push("b");
		st2.push("c");
		st2.push("a");
		for(int i = 0; i < 300; i++){
			st2.push("420");
		}
		for(int i = 0; i < 9999; i++){
			st2.push("eh");
		}
		System.out.println("testing if two identical stacks equal: " + st.equals(st2));
		st2.pop();
		System.out.println("testing if two different stacks equal: " + st.equals(st2));
	}
	public static void testBST(){
		/*
		BinarySearchTree<Integer> aa = new BinarySearchTree<Integer>();
		//aa.add(10);
		aa.add(20);
		aa.add(5);
		aa.add(30);
		aa.add(25);
		aa.add(40);
		System.out.println(aa.toString());
		System.out.println(aa.remove(25));
		System.out.println(aa.getRoot().);
		*/
	}
	//execute
	public static void main(String[]args){
		testStack();
		testQueue();
		testMap();
		//testBST();
	}
}
