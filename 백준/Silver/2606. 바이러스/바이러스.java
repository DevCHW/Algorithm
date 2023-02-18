
import java.util.*;
public class Main {
    static int vtx;
    static int edge;
    static int[][] graph;
    static int[] visited;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        vtx = sc.nextInt();
        edge = sc.nextInt();

        graph = new int[vtx+1][vtx+1];
        visited = new int[vtx+1];
        for(int i=0; i<edge; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        bfs();
        System.out.print(answer);
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = 1;

        while(!queue.isEmpty()) {
            int node = queue.poll();
            for(int i=1; i<=vtx; i++) {
                if(graph[node][i] == 1 && visited[i] == 0) {
                    visited[i] = 1;
                    queue.offer(i);
                    answer++;
                }
            }
        }
    }
}
