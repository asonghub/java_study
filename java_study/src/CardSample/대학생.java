package CardSample;

public class 대학생 {
    public String 이름;
    public int 나이;
    public String 성별;
    public String 학과;

    public 대학생(){

    }

    // 생성자 오버로딩(overloading) 
    // 하나의 클래스에서 인자의 갯수와 데이터타입이 다르면 생성자를 여러개 구현 가능
    public 대학생(String 이름){
        this.이름 = 이름;
    }
    public 대학생(String 이름, int 나이){
        //this.이름 = 이름;
        this(이름); //this 생성자
        this.나이 = 나이;
    }
    public 대학생(String 이름, int 나이, String 성별, String 학과){
        // this.이름 = 이름;
        // this.나이 = 나이;
        this(이름, 나이);
        this.성별 = 성별;
        this.학과 = 학과;
    }


    //this 생성자
    //생성자 내부에서만 사용가능
    //첫줄에만 쓸 수 있음

}
