
import java.util.*;

public class Main {
    static int vtx; //정점의 개수
    static int edge;    //간선의 개수
    static int start;   //시작정점번호
    static int[] visited;   //방문배열
    static int[][] graph;   //인접행렬 그래프
    static String answer = "";   //경로 출력할 용도 String
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        vtx = sc.nextInt();
        edge = sc.nextInt();
        start = sc.nextInt();

        visited = new int[vtx+1];

        graph = new int[vtx+1][vtx+1];
        for(int i=0; i<edge; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        visited[start] = 1; //방문처리
        answer += start + " ";
        dfs(start);
        System.out.print(answer + "\n");

        Arrays.fill(visited, 0);
        answer = start + " ";
        visited[start] = 1;
        bfs(start);
        System.out.print(answer);

    }

    private static void dfs(int start) {
        for(int i=1; i<=vtx; i++) {
            if(graph[start][i] == 1 && visited[i] == 0) {
                visited[i] = 1;
                answer += (i + " ");
                dfs(i);
            }
        }
    }
    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while(!queue.isEmpty()) {
            int currentNode = queue.poll();
            for(int i=1; i<=vtx; i++) {
                if(graph[currentNode][i] == 1 && visited[i] == 0) {
                    visited[i] = 1;
                    answer += i + " ";
                    queue.offer(i);
                }
            }
        }

    }
}
