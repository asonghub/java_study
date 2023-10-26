package java_generic;
import java.util.*;

public class CollectionPrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		Set<Integer> hashSet = new HashSet<Integer>();
		int a;
		while(true) {
			System.out.println("정수를 입력하세요");
			a = scan.nextInt();
			if(a == -1) {
				
				break;
			}
				hashSet.add(a);
		}
		System.out.println(hashSet);
		scan.close();
	}

}
