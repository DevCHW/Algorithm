import java.util.*;
public class Main {
    static int n;
    static int m;
    static char[][] board;
    static int[] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new char[n][m];
        visited = new int[26];

        for(int i=0; i<n; i++) {
            String str = sc.next();
            for(int j=0; j<m; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        System.out.println(dfs(0, 0, 0));
    }
    private static int dfs(int depth, int x, int y) {
        int idx = board[x][y] - 'A';
        if(visited[idx] == 1) {
            return depth;
        } else {
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(0 <= nx && nx < n && 0<= ny && ny < m && visited[idx] == 0) {
                    visited[idx] = 1;
                    answer = Math.max(dfs(depth + 1, nx, ny),answer);
                    visited[idx] = 0;
                }
            }// end of for--
        }
        return answer;
    }
}
