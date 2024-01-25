package algorithm;

import java.util.LinkedList;
import java.util.Queue;

import javax.lang.model.type.IntersectionType;

public class ex {
    public static boolean[] visited = {false, false,false,false,false,false,false,false,false};
    public static int[][] graph ={{},
        {2,3,8},
        {1,7},
        {1,4,5},
        {3,5},
        {3,4},
        {7},
        {2,6,8},
        {1,7}
    };
    public static void main(String[] args) {
        int start =1 ; 
        // System.out.println(start);
        // dfs(start);
        Queue<Integer> que = new LinkedList<>();

        que.add(start);
        visited[start]=true;
        while(!que.isEmpty()){
            int v = que.poll();
            System.out.print(v + " ");
            for(int i : graph[v]){
                if(!visited[i]){
                    que.add(i);
                    visited[i]=true;
                }
            }
        }
    }
    private static void dfs(int start) {
        visited[start] = true;

        for(int i : graph[start]){
            if(!visited[i]){
                System.out.println(i);
                dfs(i);
            }
        }
    }
}
