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
    static int[][] arr;
    static int[][] tmp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        tmp = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(n,arr));
    }
    private static int solution(int n, int[][] arr) {
        int max_height = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(arr[i][j] > max_height) max_height = arr[i][j];
            }
        }

        int answer = Integer.MIN_VALUE;

        for(int i=0; i<=max_height; i++) {
            int count = 0;
            for(int j=0; j<n; j++) {
                for(int k=0; k<n; k++) {
                    tmp[j][k] = arr[j][k];
                }
            }
            for(int j=0; j<n; j++) {
                for(int k=0; k<n; k++) {
                    if(tmp[j][k] > i) {
                        count++;
                        bfs(i,j,k,tmp);
                    }
                }
            }
            answer = Math.max(answer,count);
        }
        return answer;
    }

    private static void bfs(int height,int x, int y, int[][] tmp) {
        Queue<Point> queue = new LinkedList<>();
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        tmp[x][y] = -1;
        queue.offer(new Point(x, y));
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(0<= nx && nx < n && 0<= ny && ny < n && tmp[nx][ny] > height) {
                    tmp[nx][ny] = -1;
                    queue.offer(new Point(nx,ny));
                }
            }//end of for--
        }
    }
}
