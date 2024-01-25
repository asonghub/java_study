package algorithm;

public class recursion {
    public static void main(String[] args) {
        System.out.println(pibo(6));
        System.out.println(sum(10));
        
    }

    public static int pibo(int n){
        if(n==1){
            return 1;
        }else if(n==2){
            return 1;
        }else{
            return pibo(n-1)+pibo(n-2);
        }
    }

    public static int sum(int n){
        if(n==1){
            return 1;
        }else{
            return n + sum(n-1);
        }

    }
    //에라토스테네스의 체(소수구하기) 
    
}
