package second_java;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Except {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			int num1 = 4;
			int num2 = 0;
			
			System.out.println(num1 + " / " + num2 + " = " + (num1/num2));
			
		}catch(ArithmeticException e){
			System.out.println("0으로 나누어 예외가 발생하였습니다");
			System.out.println(e);
			
		}
		
		System.out.println("여기까지 읽힐까?");
		
		//index 범위를 벗어났을때
		int[] intArr = {1,2,3,4};
		try {
			for(int i = 0; i <5; i++) {
				System.out.println(intArr[i]);
			}
			
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("인덱스 범위가 벗어났습니다");
			
		}
		
		//입력오류 발생시
		Scanner scan = new Scanner(System.in);
		System.out.println("정수를 입력하세요");
		try {
			int num = scan.nextInt();
		} catch (InputMismatchException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		//숫자 변환 오류
		//NumberFormatException
		//객체참조가 null인 상태에서 객체의 메서드나 속성에 접근할 때 발생
		//NullPointerException
		
		//파일이 존재하지 않을때 (컴파일러에 의해 체크됨)
		//FileNotFoundException
		
		
		scan.close();
		

	}

}
