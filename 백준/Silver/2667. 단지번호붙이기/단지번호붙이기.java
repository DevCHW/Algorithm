
import java.util.*;

public class Main {
    static int count =0;
    static int cnt = 0;
    static int[][] graph;
    static int[][] visited;
    static int n;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        graph = new int[n][n];
        visited = new int[n][n];

        String[] graphStr = new String[n];

        for(int i=0; i<n; i++) {
            graphStr[i] = sc.next();
        }

        for(int i=0; i<n; i++) {
            String str = graphStr[i];
            for(int j=0; j<n; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        List<Integer> answerList = new ArrayList<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(graph[i][j] == 1) {
                    graph[i][j] = 0;
                    count++;    //단지수
                    cnt = 1;    //단지의 집 수
                    dfs(i, j);
                    answerList.add(cnt);
                }
            }
        }
        Collections.sort(answerList);

        System.out.println(count);
        for(int x : answerList) System.out.println(x);
    }

    private static void dfs(int x, int y) {
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(0 <= nx && nx < n && 0<= ny && ny < n && graph[nx][ny] == 1) {
                graph[nx][ny] = 0;
                cnt++;
                dfs(nx, ny);
            }
        }
    }
}
