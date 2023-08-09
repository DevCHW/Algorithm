import java.util.*;

public class Main {
    private static int n;
    private static int[][] graph;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        graph = new int[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        int[][] answer = solution();

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] solution() {
        int[][] answer = new int[n][n];

        for(int i=0; i<n; i++) {
            visited = new boolean[n];
            dfs(i);

            for(int j=0; j<n; j++) {
                if(visited[j]) answer[i][j] = 1;
            }
        }

        return answer;
    }

    private static void dfs(int start) {
        for(int i=0; i<n; i++) {
            if(graph[start][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(i);
            }
        }
    }
}
