package second_java;
import java.util.Scanner;

public class over_prac {
	public int add( int a, int b) {
		return a + b;
	}
	public int minus( int a, int b) {
		return a - b;
	}
	public int mul( int a, int b) {
		return a * b;
	}
	public double divi( double a, double b) {
		return a / b;
	}
	
	public double circle(int a) {
		return a * a * Math.PI;
	}
	public double circle(int a, int b) {
		return a * b;
	}
	public double circle(int a, double b) {
		return a * b * 0.5;
	}
	

	public static void main(String[] args) {
		over_prac calc = new over_prac();
		// TODO Auto-generated method stub
		/*
		System.out.println("숫자 두개를 입력하세요");
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		
		
		for(int i =1 ; i <= a ; i++) {
			System.out.println(i);
		}
		
		System.out.println("덧셈결과 : " + calc.add(a,b));
		System.out.println("뺄셈결과 : " + calc.minus(a,b));
		System.out.println("나눗셈결과 : " + calc.divi(a,b));
		System.out.println("곱셈결과 : " + calc.mul(a,b));
		*/
		System.out.println("반지름이 5인 원의 넓이: "+calc.circle(5));
		System.out.println("가로 4, 세로 7인 사각형의 넓이: "+calc.circle(4, 7));
		System.out.println("밑변 6, 높이 3인 삼각형의 넓이: " +calc.circle(6, 3.0));
		
//		scan.close();

	}

}
