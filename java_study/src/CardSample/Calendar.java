package CardSample;

public class Calendar {
    public final int LAST_MONTH;
    //final은 반드시 초기화가 필요. 이후에는 바꾸지 못한다
    //static final은 선언과 동시에 초기화가 필요하다

    //
    public Calendar(int month){
        LAST_MONTH = month;
    }
}
