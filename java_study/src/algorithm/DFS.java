package algorithm;

public class DFS {
    public static boolean[] visited = {false, false,false,false,false,false,false,false,false};
    public static void main(String[] args) {
        int start = 1;
        dfs(start);
        
    }

    private static void dfs(int start) {
        //시작하는 정점 방문처리
        visited[start]=true;
        System.out.print(start + " ");
        for(int i : graph[start]){
            if(!visited[i]){
                dfs(i);
            }
        }

    }

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






}
