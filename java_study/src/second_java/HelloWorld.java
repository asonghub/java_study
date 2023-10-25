package second_java;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("안녕하세요?");
		System.out.println("안녕하세요");
		//형식지정자. 
		//%d: 정수
		//%f: 실수 ( %.3f : 세번째 소수점까지 나오게 함)
		//%s: 문자열
		//%c: 문자
		//%b: boolean
		System.out.printf("%d * %d = %d", 10, 2, 20).println();
		System.out.printf("%f", 1.2345).println();
		System.out.printf("%.2f", 1.2345).println();

	}

}
