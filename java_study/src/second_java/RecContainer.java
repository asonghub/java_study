package second_java;

import java.util.ArrayList;
import java.util.Scanner;

public class RecContainer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int width=1;
		int height=1;
		ArrayList<Rectangle> rect = new ArrayList<Rectangle>();
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("사각형의 가로와 세로 길이를 띄어쓰기를 기준으로 입력해 주세요.");
			width = scan.nextInt();
			height = scan.nextInt();
			if(!(width==0&&height==0)) {
				Rectangle myRec = new Rectangle(width);				
				myRec.setHeight(height);
				rect.add(myRec);
			}else {
				for(Rectangle r : rect) {
					System.out.println("가로 길이는: "+ r.getWidth());
					System.out.println("세로 길이는: "+ r.getHeight());
					System.out.println("넓이는: "+ r.area());
					System.out.println("-----------------------");
				}
				break;
			}
		}
		System.out.println("Rectangle 인스턴스의 갯수는 : " + Rectangle.getCount());
		
		scan.close();
		
	}

}
