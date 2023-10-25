package second_java;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListPrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> arr = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		String str = "";
		
		
		do {
			System.out.println("문자를 입력해주세요.");
			str = sc.next();
			arr.add(str);
		}while(!str.equals("exit"));
		
//		sc.close();
//		for(int i =0; i<arr.size(); i++) {
//			System.out.println(arr.get(i));
//		}
		
		for( String a: arr) {
			System.out.println(a);
		}
		
		sc.close();
	}	

}
