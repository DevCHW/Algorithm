import java.util.*;
public class Main {

    static StringBuilder sb;
    static boolean[] visited;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        solution(n, m);
        System.out.println(sb);
    }
    private static void solution(int n, int m) {
        sb = new StringBuilder();

        arr = new int[n+1];
        visited = new boolean[n+1];

        combination(0, n, m);
    }

    private static void combination(int depth, int n, int m) {
        if (depth == m) {
            for(int i=0; i<m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for(int i=1; i<=n; i++) {
                if(visited[i]) continue;

                // 방문 처리
                visited[i] = true;
                arr[depth] = i;
                combination(depth+1, n, m);
                // 방문 풀기
                visited[i] = false;
            }
        }
    }
}