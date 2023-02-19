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
    static int[][] board;
    static int[][] visited;
    static int m;
    static int n;
    static Queue<Point> queue;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        queue = new LinkedList<>();
        m = sc.nextInt();
        n = sc.nextInt();
        board = new int[n][m];
        visited = new int[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                board[i][j] = sc.nextInt();
                if(board[i][j] == 1) {
                    queue.offer(new Point(i, j));
                }
            }
        }

        boolean flag = false;   //처음부터 모두 1이라면
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j] == 0) {
                    flag = true;
                }
            }
        }

        if(!flag) { //모두 익어있는 상태라면
            System.out.println(0);
        } else {    //익은 토마토가 있다면
            bfs();
            boolean check = false;
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {    // 익지않은 토마토가 발견되면
                    if(board[i][j] == 0) {
                        check = true;
                        break;
                    }
                }
            }

            if(check) System.out.println(-1);   //익지 않은 토마토가 있다면
            else {  //조건을 다 만족한다면
                int answer = Integer.MIN_VALUE;
                for(int i=0; i<n; i++) {
                    for(int j=0; j<m; j++) {
                        answer = Math.max(visited[i][j], answer);
                    }
                }
                System.out.print(answer);
            }
        }
    }

    private static void bfs() {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(0<= nx && nx< n && 0<= ny && ny< m && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    visited[nx][ny] = visited[p.x][p.y] + 1;
                    queue.offer(new Point(nx,ny));
                }
            }
        }
    }
}