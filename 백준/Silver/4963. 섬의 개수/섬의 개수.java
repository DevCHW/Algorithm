import java.util.*;
class Position {
    int x;
    int y;
    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int n;
    static int m;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while(true) {
            m = sc.nextInt();
            n = sc.nextInt();
            if(n == 0 && m == 0) break;

            map = new int[n][m];
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            sb.append(solution(n, m, map)).append("\n");
        }//end of while--
        System.out.print(sb);
    }

    private static int solution(int n, int m, int[][] map) {
        int answer = 0;
        // 1은 땅, 0은 바다
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == 1) {
                    answer++;
                    bfs(i,j);
                }
            }
        }
        return answer;
    }

    private static void bfs(int x, int y) {
        Queue<Position> queue = new LinkedList<>();
        int[] dx = {0, 0, 1, -1, 1, -1, 1, -1};
        int[] dy = {1, -1, 0, 0, 1, 1, -1, -1};
        queue.offer(new Position(x,y));
        map[x][y] = 0;

        while(!queue.isEmpty()) {
            Position p = queue.poll();
            for(int i=0; i<8; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(0<= nx && nx < n && 0 <=ny && ny < m && map[nx][ny] == 1) {
                    map[nx][ny] = 0;
                    queue.offer(new Position(nx, ny));
                }
            }

        }//end of while--
    }
}
