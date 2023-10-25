package second_java;

//static변수 없는 경우
class WithoutStatic {
	private int registered = 0;
	private String name;
	
	public WithoutStatic(String name) {
		this.name= name;
		registered++;
	}
	
	public int getRegisterd() {
		return registered;
	}
	
}

//static 변수가 있는 경우
class WithStatic{
	private static int registered = 0;
	private String name;
	
	public WithStatic(String name) {
		this.name = name;
		registered++;
	}
	
	public int getRegisterd() {
		return registered;
	}
}

//static 메소드
class MathUtil {
	private static double PI = 3.14; 	
	//메소드
	public static double circle (double radius) {
		return PI * radius * radius;
	}
	
//	일반 메소드는 인스턴스를 생성하고 써야함.
	public int test(int a) {
		return a;
	}
}

public class CompareStatic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		static 메소드는 객체 생성없이 사용가능함 
//		MathUtil math = new MathUtil();
//		math.circle(3.3);
		MathUtil.circle(3.3);
		
		WithoutStatic a = new WithoutStatic("asong");
		WithoutStatic b = new WithoutStatic("ma");
		
		System.out.println("WithoutStatic");
		System.out.println("asong: " + a.getRegisterd());
		System.out.println("ma: " + b.getRegisterd());
		
		//static 있는 경우
		WithStatic c = new WithStatic("kate");
		WithStatic d = new WithStatic("martin");
		System.out.println("With Static");
		System.err.println("kate: " + c.getRegisterd());
		System.err.println("martin: " + d.getRegisterd());
	}

}
