import java.util.*;
public class Main {
    static int[] visited;
    static int[][] graph;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();   //정점의 개수
        int m = sc.nextInt();   //간선의 개수
        visited = new int[n+1];
        graph = new int[n+1][n+1];
        for(int i=1; i<=m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        System.out.println(solution(n, m, graph));
    }

    private static int solution(int n, int m, int[][] graph) {
        int answer = 0;
        for(int i=1; i<=n; i++) {
            if(visited[i] == 0) {
                answer++;
                dfs(i);
            }
        }
        return answer;
    }
    private static void dfs(int vtx) {
        if(visited[vtx] == 1) return;
        else {
            visited[vtx] = 1;
            for(int i=1; i<=n; i++) {
                if(graph[vtx][i] == 1) dfs(i);
            }
        }
    }
}
