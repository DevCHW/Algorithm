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

    // BFS 탐색을 위한 Queue 정의.
    static Queue<Position> queue = new LinkedList<>();

    // 방향벡터 정의(상, 하, 좌, 우, 대각선)
    static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
    static int[] dy = {0, 1, 0, -1, -1, 1, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while(true) {
            int w = sc.nextInt();
            int h = sc.nextInt();
            if(w == 0 && h == 0) break;

            int[][] graph = new int[h][w];

            for(int i=0; i<h; i++) {
                for(int j=0; j<w; j++) {
                    graph[i][j] = sc.nextInt();
                }
            }

            sb.append(solution(w, h, graph)).append("\n");
        }

        System.out.println(sb);
    }

    private static int solution(int w, int h, int[][] graph) {
        // 방문처리 그래프 정의
        visited = new boolean[h][w];

        int answer = 0;

        // 지도 탐색
        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) { // 땅을 만난다면
                    answer++;
                    bfs(graph, i, j, w, h);
                }
            }
        }

        return answer;
    }

    private static void bfs (int[][] graph, int x, int y, int weight, int height) {
        // bfs 시작지점 queue에 삽입, 방문처리
        queue.add(new Position(x, y));
        visited[x][y] = true;   //방문처리

        // queue가 빌 때 까지 그래프 탐색.
        while(!queue.isEmpty()) {
            Position pos = queue.poll();

            for(int i=0; i<8; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];

                if(nx >= 0 && nx < height && ny >= 0 && ny < weight
                        && graph[nx][ny] == 1
                        && !visited[nx][ny] ) {
                    visited[nx][ny] = true; //방문처리
                    queue.offer(new Position(nx, ny));
                }
            }
        }
    }
}