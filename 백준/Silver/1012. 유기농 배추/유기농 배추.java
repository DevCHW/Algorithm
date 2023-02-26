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
    static int m;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> answerList = new ArrayList<>();
        int t = sc.nextInt();
        for(int i=0; i<t; i++) {
            m = sc.nextInt();   //배추밭의 가로길이
            n = sc.nextInt();   //배추밭의 세로길이
            int[][] graph = new int[m][n];
            int[][] visited = new int[m][n];
            int k = sc.nextInt();   //배추 위치갯수
            for(int j=0; j<k; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                graph[x][y] = 1;
            }
            int count = 0;
            for(int j=0; j<m; j++) {
                for(int s=0; s<n; s++) {
                    if(graph[j][s] == 1) {
                        count++;
                        bfs(graph, j, s);
                    }
                }
            }
            answerList.add(count);
        }
        for(int x : answerList) {
            System.out.println(x);
        }
    }
    private static void bfs(int[][] graph, int x, int y) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<Point> queue = new LinkedList<>();
        int count = 0;
        queue.offer(new Point(x, y));
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(0<= nx && nx < m && 0<= ny && ny < n && graph[nx][ny] == 1) {
                    graph[nx][ny] = 0;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
    }
}