
import java.util.*;
class Point {
    int x;
    int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int n;
    static int m;
    static int[][] graph;
    static int[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        graph = new int[n+1][m+1];
        visited = new int[n+1][m+1];

        String[] input = new String[n+1];
        for(int i=1; i<=n; i++) {
            input[i] = sc.next();
        }

        for(int i=1; i<=n; i++) {
            String str = input[i];
            for(int j=1; j<=m; j++) {
                graph[i][j] = (str.charAt(j-1)-'0');
            }
        }
        bfs();
        int answer = visited[n][m];
        System.out.print(answer);
    }

    public static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(1, 1));
        visited[1][1] = 1;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while(!queue.isEmpty()) {
            Point p = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(0< nx && nx <= n && 0 < ny && ny <= m && graph[nx][ny] == 1 && visited[nx][ny] == 0) {
                    visited[nx][ny] = visited[p.x][p.y] + 1;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
    }
}
