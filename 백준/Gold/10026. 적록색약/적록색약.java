import java.util.Scanner;

public class Main {
    static char[][] arr;
    static int[][] visited; //일반인 방문배열
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new char[n][n];
        visited = new int[n][n];

        for(int i=0; i<n; i++) {
            String str = sc.next();
            for(int j=0; j<n; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        solution(n, arr);
    }

    private static void solution(int n, char[][] arr) {
        // 적록색약 -> 빨간색과 초록색 같음
        // 일반인 -> 다 다름

        int count1 = 0;
        int count2 = 0;
        //일반인 구역의 수 구하기
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(visited[i][j] == 0) {
                    count1++;
                    dfs(i, j, arr[i][j]);
                }
            }
        }

        // 적록색약의 구역 수를 구하기 위하여 'R'을 'G'로 전부 바꿈
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(arr[i][j] == 'R') {
                    arr[i][j] = 'G';
                }
                visited[i][j] = 0;
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(visited[i][j] == 0) {
                    count2++;
                    dfs(i, j, arr[i][j]);
                }
            }
        }

        System.out.println(count1);
        System.out.println(count2);
    }

    private static void dfs(int x, int y, char color) {
        visited[x][y] = 1; //방문처리
        for(int i=0; i<4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < n && visited[nx][ny] == 0 && arr[nx][ny] == color) {
                dfs(nx, ny, color);
            }
        }
    }
}
