package java_generic;
import java.util.*;

public class Collection {

	public static void main(String[] args) {
		
		List<String> arrayList = new ArrayList<>();
		//LinkedList
		List<String> linkedList = new LinkedList<String>();
		linkedList.add("A");
		linkedList.add("B");
		linkedList.add(1, "C");
		System.out.println(linkedList); // A,C,B
		
		
		//HashSet
		Set<String> hashSet = new HashSet<String>();
		hashSet.add("A");
		hashSet.add("B");
		hashSet.add("A");
		System.out.println(hashSet); //중복을 제거하기 때문에 A,B만 출력
		//LinkedHashSet
		Set<String> linkedHashSet = new LinkedHashSet<String>();
		linkedHashSet.add("C");
		linkedHashSet.add("B");
		linkedHashSet.add("A");
		System.out.println(linkedHashSet);
		//TreeSet
		Set<String> treeSet = new TreeSet<String>();
		treeSet.add("B");
		treeSet.add("C");
		treeSet.add("A");
		System.out.println(treeSet); //자동 정렬 A,B,C
		
		//HashMap
		Map<String, Integer> hashMap = new HashMap<String, Integer>();
		hashMap.put("one", 1); //키, 밸류 형태로 넣기.
		hashMap.put("two", 2);
		hashMap.put("three", 3);
		System.out.println(hashMap);
		System.out.println(hashMap.get("one"));
		
		//LinkedHashMap : 내가 넣은 순서대로 나옴. 
		Map<String, Integer> link = new LinkedHashMap<String, Integer>();
		link.put("two", 2);
		link.put("three",3);
		link.put("one",1);
		System.out.println(link);
		System.out.println(link.get("three"));
		
		//TreeMap
		Map<String, Integer> treeMap = new TreeMap<String, Integer>();
		treeMap.put("C", 2);
		treeMap.put("A",1);
		treeMap.put("B",3);
		System.out.println(treeMap); //A,b,c 
		
	}

}
