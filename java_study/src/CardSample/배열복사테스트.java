package CardSample;

import java.util.Arrays;

public class 배열복사테스트{
    public static void main(String[] args) {
        //얕은복사(주소지정)
        int[] a1 = {1,2,3,4};
        int[] a2 = a1;

        //깊은복사(메모리를 새로 할당)
        int[] a3 = new int[a1.length];
        for(int i = 0; i <a1.length; i++){
            a3[i] = a1[i];
        }

        //배열복사1 - Object.clone()
        int[] c1 = {1,2,3,4};
        int[] c2 = c1.clone();
        
        //배열복사2 - .copyOf()
        int[] d1= {1,2,3,4};
        int[] d2 = Arrays.copyOf(d1, d1.length);

        //배열복사3 - .arraycopy()
        int[] e1 = {1,2,3,4};
        int[] e2 = new int[e1.length];
        System.arraycopy(e1,0,e2,0,e1.length);
    }
}
