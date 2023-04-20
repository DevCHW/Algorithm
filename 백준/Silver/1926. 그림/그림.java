import java.util.Scanner;

public class Main {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] visited;
    static int n;
    static int m;
    static int tmp;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];
        visited = new int[n][m]; //방문배열 초기화

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        solution();
    }

    private static void solution() {
        int count = 0; //그림의 개수
        int size = 0; //그림의 넓이


        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(visited[i][j] == 0 && arr[i][j] == 1) {
                    count++; //그림의 개수 증가
                    tmp = 1;
                    dfs(i, j);
                    size = Math.max(size, tmp);
                }
            }
        }
        System.out.println(count);
        System.out.println(size);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = 1; //방문처리
        for(int i=0; i<4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < m && visited[nx][ny] == 0 && arr[nx][ny] == 1) {
                tmp++;
                dfs(nx, ny);
            }
        }
    }
}
