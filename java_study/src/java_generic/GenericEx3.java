package java_generic;
import java.util.ArrayList;

public class GenericEx3 {
	
	//와일드카드 
	public void processList(ArrayList<? extends Number> list) {
		//list.add(1); //리스트에 어떤 타입이 올지 모르기때문에 넣을 수 없음. 
		
		//출력은 가능
		for(Number num: list) {
			System.out.println(num);
		}	
	}
	
	//타입파라미터
	public <T extends Number> void addToNumberList(ArrayList<T> list, T item) {
		list.add(item);
	}
	
	//? super T (최소한의 타입 지정(?))
	public void processList2(ArrayList<? super Integer > list) {
		list.add(1); //가능
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericEx3 example = new GenericEx3();
		ArrayList<Integer> integerList = new ArrayList<Integer>();
		integerList.add(1);
		integerList.add(2);
		integerList.add(3);
		
		ArrayList<Double> doubleList = new ArrayList<Double>();
		doubleList.add(1.1);
		doubleList.add(2.2);
		doubleList.add(3.3);
		
		//와일드카드 <? extends T> 는 읽기 전용으로 주로 사용 
		example.processList(integerList);
		example.processList(doubleList);
		
		example.addToNumberList(integerList, 4);
		example.addToNumberList(doubleList, 4.4);
		
		System.out.println("----------------");
		example.processList(integerList);
		example.processList(doubleList);
		
		//와일드카드 <? super T>는 쓰기 전용으로 주로 사용
		ArrayList<Number> numbers = new ArrayList<Number>();
		example.processList2(numbers);
		System.out.println(numbers);
		
		//와일드카드 주의사항
		//1. 복잡성: 와일드카드를 과도하게 사용하면 복잡성이 증가하며, 협업에 맞지 않음
		//2. 제한된 작업: '? extends T'같은 경우 새로운 요소 추가 불가능
	}

}
