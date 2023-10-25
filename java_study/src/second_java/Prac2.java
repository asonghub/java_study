package second_java;
import java.util.Scanner;

public class Prac2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("나이를 입력하세요");
		Scanner scan = new Scanner(System.in);
		int age = scan.nextInt();
				
		if(age > 0 && age<= 7) {
			System.out.println("유아");
		}else if(age > 7 && age<= 13) {
			System.out.println("초등학생");
			
		}else if(age > 13 && age<= 16) {
			System.out.println("중학생");
		}else if(age>16 && age <=19) {
			System.out.println("고등학생");
		}else {
			System.out.println("성인");
		};
		
		System.out.println("이름을 입력하세요");
		
		String name = scan.next();
		
		if(name.equals("이몽룡")) {
			System.out.println("남자");
		}else if(name.equals("성춘향")) {
			System.out.println("여자");
		}else {
			System.out.println("모르겠어요");
		}
		
		scan.close();
	}
}
