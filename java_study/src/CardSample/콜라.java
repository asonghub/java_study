package CardSample;

//멤버변수의 초기화 방법
// 1. 명시적 초기화
// 2. 초기화 블럭
// 3. 생성자 초기화
public class 콜라 {
    private static int 용량 = 20;
    private int 제조일자 = 10;

    static {
        //클래스가 최초로 만들어질때 실행되고 이후 인스턴스 실행단계에선 실행 안됨

        System.out.println("클래스 초기화 블럭");
        // 제조일자 = 50; //에러. static이 아니라서
            용량 = 40;
        System.out.println("용량 = " + 용량);
    }
    {
        System.out.println("인스턴스 초기화 블럭");
        제조일자 = 50;
        용량 = 50;
        System.out.println("용량 = " + 용량);

    }

    public 콜라() {
        System.out.println("생성자 호출");
        용량 = 60;
        제조일자 =60;
        System.out.println("용량 = " + 용량);

    }
}
