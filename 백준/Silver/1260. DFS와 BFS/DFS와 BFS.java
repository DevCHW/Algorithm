import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();   //정점의 개수
        m = sc.nextInt();   //간선의 개수
        int start = sc.nextInt();

        graph = new int[n+1][n+1];

        // 간선의 개수(연결정보의 개수)만큼 입력받기
        for(int i=0; i<m; i++) {
            int vtx1 = sc.nextInt();
            int vtx2 = sc.nextInt();

            graph[vtx1][vtx2] = 1;
            graph[vtx2][vtx1] = 1;
        }

        print(solution(start));
    }

    private static StringBuilder solution(int start) {
        StringBuilder sb = new StringBuilder();
        visited = new boolean[n+1];

        // DFS
        sb.append(start).append(" ");
        visited[start] = true;
        dfs(start, sb);

        // BFS
        sb.append("\n");
        Arrays.fill(visited, false);
        sb.append(start).append(" ");
        bfs(start, sb);

        return sb;
    }

    private static void dfs(int vertex, StringBuilder sb) {
        for(int i=1; i<=n; i++) {
            if (graph[vertex][i] == 1) { //연결되어 있다면
                if (!visited[i]) { //방문하지 않았다면
                    visited[i] = true;  //방문처리
                    sb.append(i).append(" ");
                    dfs(i, sb);
                }
            }
        }
    }

    private static void bfs(int start, StringBuilder sb) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        // 큐가 빌 때 까지 반복.
        while(!queue.isEmpty()) {
            int vertex = queue.poll();

            for(int i=1; i<=n; i++) {
                if(graph[vertex][i] == 1) {
                    if(!visited[i]) {
                        visited[i] = true;
                        queue.offer(i);
                        sb.append(i).append(" ");
                    }
                }
            }
        }
    }


    /**
     * print() 구현
     */
    private static void print(String str) {
        System.out.println(str);
    }

    /**
     * print() 구현
     */
    private static void print(int number) {
        System.out.println(number);
    }

    private static void print(StringBuilder sb) {
        System.out.print(sb);
    }
}
