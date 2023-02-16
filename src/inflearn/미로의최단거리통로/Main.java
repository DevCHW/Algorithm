package inflearn.미로의최단거리통로;


import java.util.*;


public class Main {
    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int[][] visited = new int[8][8];
    private static void bfs(int x, int y, int[][] arr) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        while(!queue.isEmpty()){
            Point o = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = o.x + dx[i];
                int ny = o.y + dy[i];
                if(0<nx && nx <=7 && 0<ny && ny<=7 && arr[nx][ny] == 0) {
                    arr[nx][ny] = 1;
                    queue.offer(new Point(nx,ny));
                    visited[nx][ny] = visited[o.x][o.y]+1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[8][8];
        for(int i=1; i<8; i++) {
            for(int j=1; j<8; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        bfs(1, 1, arr);
        if(visited[7][7]==0) System.out.println(-1);
        else System.out.println(visited[7][7]);
    }
}

