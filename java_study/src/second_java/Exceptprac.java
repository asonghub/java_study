package second_java;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exceptprac {
	public static void main(String[] args) {
		
//		int[] arr = {1,2,3,4};
//		try {
//			for(int i =0; i <5; i ++) {
//				System.out.println(arr[i]);
//			}
//			
//		} catch (ArrayIndexOutOfBoundsException e) {
//			// TODO: handle exception
//			System.out.println("인덱스가 범위를 벗어났습니다");
//		}
		
		Scanner scan = new Scanner(System.in);
		
		try {
			System.out.println("배열의 크기 입력하세요");
			int s = scan.nextInt();	
			int sum = 0;
//			if(s == 0) {
//				sum = s/0;
//			}
			System.out.printf("%d 개의 숫자를 입력하세요", s);
			double[] arr = new double[s];
			for(int i = 0 ; i <s ; i++) {
				arr[i]= scan.nextDouble();
				sum += arr[i];
			}
			
			System.out.println("배열의 평균은" + (double)(sum/s));
		}catch (InputMismatchException e) {
			// TODO: handle exception
			System.out.println("배열은 정수를 입력하세요");
		}catch (NegativeArraySizeException e) {
			// TODO: handle exception
			System.out.println("배열의 크기는 양수로  입력하세요");
		}catch (ArithmeticException e) {
			// TODO: handle exception
			System.out.println("배열의 크기가 0이기 때문 평균을 계산할 수 없습니다");
		}
		scan.close();
	}

}
