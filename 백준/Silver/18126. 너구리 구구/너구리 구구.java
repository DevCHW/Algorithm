import java.util.Scanner;

public class Main {
    static int[][] arr;
    static int[] visited;
    static int n;
    static long dist;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n+1][n+1];
        visited = new int[n+1];

        for(int i=1; i<n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            arr[a][b] = c;
            arr[b][a] = c;
        }
        solution();
        System.out.println(dist);
    }

    private static void solution() {
        visited[1] = 1;
        dfs(1, 0);
    }

    private static void dfs(int vertex, long distance) {
        dist = Math.max(dist, distance);
        for(int i=1; i<=n; i++) {
            if(arr[vertex][i] != 0 && visited[i] == 0) {
//                System.out.println(vertex+"에서 "+i+"번 방으로 갑니다. 비용 =" +arr[vertex][i]);
                visited[i] = 1;
                dfs(i, distance+ arr[vertex][i]);
                visited[i] = 0;
            }
        }
    }
}
