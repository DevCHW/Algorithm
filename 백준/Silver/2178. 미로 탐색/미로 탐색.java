import java.util.*;
public class Main {
    static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();;
        int m = sc.nextInt();;
        int[][] graph = new int[n+1][m+1];

        for(int i=1; i<=n; i++) {
            String tmp = sc.next();
            for(int j=1; j<=m; j++) {
                graph[i][j] = tmp.charAt(j-1)-'0';
            }
        }

        System.out.println(solution(n, m, graph));
    }

    private static int solution(int n, int m, int[][] graph) {
        int answer = bfs(n, m, graph);
        return answer;
    }

    private static int bfs(int n, int m, int[][] graph) {
        int[][] visited = new int[n+1][m+1];

        Queue<Position> queue = new LinkedList<>();

        //시작위치 삽입, 방문처리
        queue.offer(new Position(1, 1));
        visited[1][1] = 1;

        // 방향벡터 정의
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while(!queue.isEmpty()) {
            Position pos = queue.poll();

            for(int i=0; i<4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];

                if(nx >= 1 && nx <= n && ny >= 1 && ny <= m
                        && visited[nx][ny] == 0
                        && graph[nx][ny] == 1) {

                    // 현재위치 + 1 한 것을 방문배열에 넣기
                    visited[nx][ny] = visited[pos.x][pos.y] + 1;

                    queue.offer(new Position(nx, ny));
                }
            }
        }
        return visited[n][m];
    }
}