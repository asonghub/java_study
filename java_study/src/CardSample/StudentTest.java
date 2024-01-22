package CardSample;

public class StudentTest {
    public static void main(String[] args) {
        
        // 1. 기본 생성자
        Student student1 = new Student(); 
        student1.name = "박하은";
        System.out.println(student1.name);

        // 2. 사용자 지정 생성자
        Student student2 = new Student("박하은2"); 
        System.out.println(student2.name);
    }
    
}
