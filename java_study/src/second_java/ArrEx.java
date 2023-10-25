package second_java;
import java.util.Arrays;
import java.util.Scanner;

public class ArrEx {
	
	public static void main(String[] args) {
		
//		int[] intArray = {1,2,3,4,5};
//		
		//배열 출력 기초 
		//방법1 for문 활용 
//		for(int i = 0; i < intArray.length; i++) {
//			System.out.print(intArray[i]+ " ");
//		}
		
		Scanner  scan = new Scanner(System.in);
		int[] intArray = new int[5]; //크기가 5인 int배열 
		
		System.out.println("숫자 5개를 입력하세요");
		for( int i = 0 ; i < intArray.length; i++) {
			intArray[i] = scan.nextInt();
		}
		//방법2 Array.toString 배열의 요소를 문자열로 반환 
		//string으로 변환하지 않으면 이상한문자로 출력됨. 
		System.out.println(Arrays.toString(intArray));
		System.out.println(intArray);
		
		//방법3 for-each 
		int sum = 0;
		for( int arr: intArray) {
			System.out.print(arr + " ");
			sum += arr;
		}
		System.out.println(sum);
		
		
		
		
		scan.close();
	}

}
