package CardSample;

public class Circle {

    double radius; //반지름
    static  double PI = 3.14; // 클래스를 생성할때마다 8byte의 메모리를 잡아먹음
    // static은 이 영역을 클래스가 가지고 있기 때문에 공유해서 사용함. 메모리를 한번만 할당

    public Circle(double radius){
        this.radius = radius;
    }

    public double getArea(){
        return PI * radius * radius;
    }
    public double getPerimeter(){
        return  PI * radius * 2;
    }

}
