package CardSample;

public class Student {
    public String name;

    //기본생성자
    public Student(){
        System.out.println("학생 생성자가 호출되어짐");
    }
    
    // 매개변수를 받아서 만드는 생성자
    // 내가 생성자를 임의로 만들면 기본 생성자는 자동으로 생성되지 않음. 내가 명시적으로 기본생성자를 만들어놔야함.
    public Student(String name){
        System.out.println("이름 파라미터를 갖는 학생 생성자 호출");
        this.name = name;
    }
}
