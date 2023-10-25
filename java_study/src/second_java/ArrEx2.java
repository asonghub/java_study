package second_java;
import java.util.Scanner;
import java.util.Arrays;

public class ArrEx2 {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//이차원 배열로 4년 평점 구하기(1~4학년까지)
		double[][] score = {{3.5, 3.7},{4.0, 2.0 },{ 3.2, 4.1},{2.7, 3.9}};
		
		double sum = 0;
		for(int i = 0; i < score.length; i++) {	//학년별 
			for(int j = 0; j < score[i].length; j++) { //학년의 학기별 
				sum += score[i][j]; //전체평점 합
			}
		}
		int n = score.length;
		int m = score[0].length;
		System.out.println(sum/(n*m));
		
		//실
		Scanner scan = new Scanner(System.in);
		int[] arr = new int[5];
		System.out.println("숫자 5개를 입력하세요");
		for( int i = 0 ; i < arr.length; i++) {
			arr[i] = scan.nextInt();
		};
		
		int sum2 = 0;
		for(int a:arr ) {
			sum2 += a; 
		}
		double avg = (double)sum2/5;
		System.out.println(avg);
		System.out.println((double)sum2/5);
		scan.close();
		
	}

}
