import java.util.ArrayList;

/**
 * A map designed for simplicity, not speed.
 * For your own try and implement your own arraylist.
 */
public class SimpleMap<K,V> {
	@SuppressWarnings("hiding")
	private class Pair<K,V> {
		//key and value
		private K key;
		private V value;
	}
	private ArrayList<Pair<K,V>> pairs;
	/**
	 * Create an empty map
	 */
	public SimpleMap(){
		pairs = new ArrayList<Pair<K,V>>();
	}
	public SimpleMap(K key, V value){
		this();
		Pair<K,V> pr = new Pair<K,V>();
		pr.key = key;
		pr.value = value;
		pairs.add(pr);
	}
	/**
	 * @return true if this map is empty.
	 */
	public boolean isEmpty(){
		return size() == 0;
	}
	/**
	 * @return true whether this map contains the given key.
	 * @param key is the key we are checking for.
	 */
	public boolean ContainsKey(K key){
		for(Pair<K,V> pr: pairs){
			if(pr.key != null && pr.key.equals(key)) return true;
		}
		return false;
	}
	/**
	 * @return whether this map contains the given value
	 * @param value is the value we are checking for
	 */
	public boolean ContainsValue(V value){
		for(Pair<K,V> pr: pairs){
			if(pr.value != null && pr.value.equals(value)) return true;
		}
		return false;
	}
	/**
	 * clear the entire map.
	 */
	public void clear(){
		pairs = new ArrayList<Pair<K,V>>();
	}
	/**
	 * Remove unused pairs.
	 * This is here since this implementation of a map is so
	 * bad for large maps.
	 */
	public void clean(){
		for(int i = pairs.size()-1; i >= 0; i--){
			if(pairs.get(i).key == null)pairs.remove(i);
		}
	}
	/**
	 * @return a copy in a different memory spot.
	 */
	public SimpleMap<K,V> clone(){
		@SuppressWarnings("unchecked")
		ArrayList<Pair<K,V>> pr = (ArrayList<Pair<K, V>>)pairs.clone();
		SimpleMap<K,V> mp = new SimpleMap<K,V>();
		mp.pairs = pr;
		return mp;
	}
	/**
	 * Get the value stored at key.
	 * @param key represents the key we are getting the value from.
	 * @return the value from the key.
	 */
	public V get(K key){
		for(Pair<K,V> pr: pairs){
			if(pr.key != null && pr.key.equals(key)) return pr.value;
		}
		return null;
	}
	/**
	 * Put a value at a key.
	 * @param key represents the key we put the given value at.
	 * @param value is the value we put at key.
	 * @return the previous value at the given key; null if there was
	 * nothing there.
	 */
	public V put(K key, V value){
		for(Pair<K,V> pr: pairs){
			if(pr.key != null && pr.key.equals(key)){
				V _val = pr.value;
				pr.value = value;
				return _val;
			}
		}
		//if it was note present
		Pair<K,V> pa = new Pair<K,V>();
		pa.key = key;
		pa.value = value;
		pairs.add(pa);
		return null;
	}
	/**
	 * Remove the key, value pair given by the key.
	 * @param key represents the reference to the key,value pair
	 * that we are removing.
	 * @return the removed value, null if not there.
	 */
	public V remove(K key){
		for(int i = 0; i < pairs.size(); i++){
			Pair<K,V> pr = pairs.get(i);
			if(pr.key != null && pr.key.equals(key)){
				V _val = pr.value;
				pairs.remove(i);
				return _val;
			}
		}
		return null;
	}
	/**
	 * @return the size of the map.
	 * (number of pairs and values.
	 */
	public int size(){
		int i = 0;
		for(Pair<K,V> pr: pairs){
			if(pr.key != null) i++;
			if(pr.value != null) i++;
		}
		return i;
	}
	/**
	 * @return a string representation of the map.
	 * It is in the format: key1: value, key2: value, 
	 * etc...
	 * 
	 * If it is null the value will be empty, so be careful of confusion
	 * with empty strings as values.
	 */
	@Override
	public String toString(){
		clean();
		if(pairs.size() == 0) return "[]";
		String str = "";
		for(Pair<K,V> pr: pairs){
			if(pr.value == null){
				str += pr.key.toString() + ": , ";
			}
			else{
				str += pr.key.toString() + ": " + pr.value.toString() + ", ";
			}
		}
		return str.substring(0, str.length()-2);
	}
	/**
	 * @return wehther this map equals the given map
	 * (false if it's not a map)
	 * @param mp represents the map we are comparing ourselves to
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object mp){
		if(!(mp instanceof SimpleMap)) 
			return false;
		clean();
		((SimpleMap<K, V>)mp).clean();
		return toString().equals(mp.toString());
		
	}
}
