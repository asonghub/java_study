package java_generic;


class Pair<K,V>{
	private K key;
	private V value;
	
	public Pair(K key, V value) {
		setKey(key);
		setValue(value);
	}
	
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	
	
}

public class GenericPrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Pair<String, Integer> pair1 = new Pair<>("one", 1);
		Pair<Integer,String> pair2 = new Pair<>(2, "two");
		
		System.out.println("Key: "+ pair1.getKey() + ", Value: " + pair1.getValue());
		System.out.println("Key: "+ pair2.getKey() + ", Value: " + pair2.getValue());
	}

}
