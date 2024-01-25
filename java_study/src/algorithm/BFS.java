package algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
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
        int start = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int v = queue.poll();
            System.out.println(v);
            for(int i : graph[v]){
                if(!visited[i]){
                    queue.add(i);
                    visited[i] = true;
                    
                }
            }
        }
    }
    
}
