package algorithm;
import java.util.Scanner;

public class 음료수얼려먹기 {
    public static int n,m;
    public static int[][] graph = new int[1000][1000];
    
    public static boolean dfs(int x, int y){
        if(x<0 || x>=n || y<0 || y>=m){
            return false;
        };
        if(graph[x][y]==0){
            graph[x][y]=1;
            dfs(x, y+1);
            dfs(x, y-1);
            dfs(x-1, y);
            dfs(x+1, y);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int cnt =0;

        for( int i=0; i<n;i++){
            String str = sc.next();
            for(int j=0; j<m ; j++){
                graph[i][j]=str.charAt(j)-'0';
            }
        }
        
        for( int i=0; i<n;i++){
            for(int j=0; j<m ; j++){
                if(dfs(i, j)){
                    cnt++;
                }
            }
        }
        
        System.out.println(cnt);
        sc.close();
        

    }
    
}
