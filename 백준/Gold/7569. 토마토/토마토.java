import java.util.*;
class Point {
    int x;
    int y;
    int z;
    Point(int z, int x, int y) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
public class Main {
    static Queue<Point> queue;
    static int[][][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        queue = new LinkedList<>();

        int m = sc.nextInt();
        int n = sc.nextInt();
        int h = sc.nextInt();
        int[][][] arr = new int[h][n][m];
        visited = new int[h][n][m];
        boolean allPass = true; //모든 토마토가 익은 상태로 들어왔으면 true;
        for(int i=0; i<h; i++) {
            for(int j=0; j<n; j++) {
                for(int k=0; k<m; k++) {
                    arr[i][j][k] = sc.nextInt();
                    if(arr[i][j][k] == 1) queue.offer(new Point(i, j, k));
                    if(arr[i][j][k] == 0) allPass = false;
                }
            }
        }
        if(allPass) System.out.println(0);  //토마토가 모두 익은상태로 들어왔으면 0 출력
        else {
            bfs(n, m, h, arr);
            boolean flag = false;
            for(int i=0; i<h; i++) {
                for(int j=0; j<n; j++) {
                    for(int k=0; k<m; k++) {
                        if(arr[i][j][k] == 0) {
                            flag = true;
                            break;
                        }
                    }
                    if(flag) break;
                }
                if(flag) break;
            }

            if(flag) System.out.println(-1);    //모든 토마토가 익지는 못하는 상황이라면 -1 출력
            else {
                int answer = Integer.MIN_VALUE;
                for(int i=0; i<h; i++) {
                    for(int j=0; j<n; j++) {
                        for(int k=0; k<m; k++) {
                            if(visited[i][j][k] > answer) {
                                answer = visited[i][j][k];
                            }
                        }
                    }
                }
                System.out.println(answer);
            }
        }
    }
    
    private static void bfs(int n, int m, int h, int[][][] arr) {
        int[] dx = {0, 0, 1, -1, 0, 0};
        int[] dy = {0, 0, 0, 0, 1, -1};
        int[] dz = {1, -1, 0, 0, 0, 0};
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            for(int i=0; i<6; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                int nz = p.z + dz[i];

                if(0<= nx && nx < n && 0<= ny && ny < m && 0<= nz && nz < h && arr[nz][nx][ny] == 0) {
                    arr[nz][nx][ny] = 1;    //토마토 익히기
                    visited[nz][nx][ny] = visited[p.z][p.x][p.y] + 1;
                    queue.offer(new Point(nz, nx, ny));
                }
            }
        }

    }
}
