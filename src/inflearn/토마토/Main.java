package inflearn.토마토;

import java.util.*;

public class Main {
    static class Point {
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[n][m];
        int[][] day = new int[n][m];
        Queue<Point> queue = new LinkedList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                arr[i][j] = sc.nextInt();
                if(arr[i][j] == 1) {
                    queue.offer(new Point(i, j));
                }
            }
        }
        Main T = new Main();
        T.bfs(queue, n, m, arr, day);

        boolean flag = true;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(arr[i][j] == 0) {
                    flag = false;
                    break;
                }
            }
        }
        int answer = Integer.MIN_VALUE;
        if(!flag) System.out.print(-1);
        else {
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    answer = Math.max(answer, day[i][j]);
                }
            }
            System.out.print(answer);
        }
    }

    public void bfs(Queue<Point> queue, int n, int m, int[][] arr, int[][] day) {
        while(!queue.isEmpty()) {
            Point o = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = o.x + dx[i];
                int ny = o.y + dy[i];
                if(0<= nx && nx < n && 0<= ny && ny < m && arr[nx][ny] == 0) {
                    arr[nx][ny] = 1;
                    queue.offer(new Point(nx,ny));
                    day[nx][ny] = day[o.x][o.y] + 1;
                }
            }
        }
    }

}

