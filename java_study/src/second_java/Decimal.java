package second_java;
import java.math.BigDecimal;

public class Decimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 클래스 자체가 타입이 됨.
		BigDecimal a = new BigDecimal("0.12");
		BigDecimal b = new BigDecimal("0.12");
		
		BigDecimal sum = a.add(b); 
		BigDecimal diff = a.subtract(b);
		BigDecimal multi = a.multiply(b);
		BigDecimal divi = a.divide(b); //무한으로 결과가 나오면 오류가 뜸(정확하게 찾아주는 대신..)
		
		System.out.println(sum);
		System.out.println(diff);
		System.out.println(multi);
		System.out.println(divi);


	}

}
