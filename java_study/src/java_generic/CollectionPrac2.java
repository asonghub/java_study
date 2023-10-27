package java_generic;
import java.util.*;

public class CollectionPrac2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		String name;
		int age;
		Map<String,Integer> user = new HashMap<String, Integer>();
		
		while(true) {
			System.out.print("이름을 입력하세요");
			name = scan.next();
			if(name.equals("종료")) {
				break;
			}
			System.out.print("나이를 입력하세요");
			age = scan.nextInt();
			
			scan.nextLine();
			
			user.put(name, age);
		}
//		System.out.println(user);
		
		//entrySet(): 해당 맵에 저장된 모든 키-값 쌍을 Set<Map.Entry<K,V>> 형태로 변함 
		for(Map.Entry<String, Integer> entry: user.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		scan.close();
	}

}
