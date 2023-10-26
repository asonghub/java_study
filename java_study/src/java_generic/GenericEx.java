package java_generic;

import java.util.ArrayList;

//일반 클래스
class MyCustomList {
	ArrayList<String> list = new ArrayList<>();

	public void addElement(String element) {
		list.add(element);
	}

	public void removeElement(String element) {
		list.remove(element);
	}
}

//제네릭 클래스
class MyCustomListGeneric<T> {

	ArrayList<T> list = new ArrayList<>();

	public void addElement(T element) {
		list.add(element);
	}

	public void removeElement(T element) {
		list.remove(element);
	}

	//<T>: 타입파라미터, 명시적으로 해당 메서드가 제네릭이라는것을 표현
	public T get(int i) {
		// TODO Auto-generated method stub
		return list.get(i);
	}
}

public class GenericEx {

	public static void main(String[] args) {
		MyCustomList list = new MyCustomList();
		list.addElement("element");

		MyCustomListGeneric<String> list2 = new MyCustomListGeneric<>();
		list2.addElement("element1");
		list2.addElement("element3");
		list2.addElement("element3");
		
		String text = list2.get(1);
		System.out.println(text);

	}

}
