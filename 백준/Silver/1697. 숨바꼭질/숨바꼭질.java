import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(bfs(n, k));
    }
    private static int bfs(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        int[] dx = {1, -1, 2*n};
        int[] visited = new int[100001];
        visited[n] = 1;
        while(!queue.isEmpty()) {
            int current = queue.poll();
            dx[2] = 2*current;

            for(int i=0; i<3; i++) {
                int nx = current + dx[i];
                if(i == 2) nx = dx[i];

                if(0<= nx && nx<= 100000 && visited[nx] == 0) {
                    visited[nx] = visited[current] + 1;
                    queue.offer(nx);
                }
            }
        }
        return visited[k] - 1;
    }
}
