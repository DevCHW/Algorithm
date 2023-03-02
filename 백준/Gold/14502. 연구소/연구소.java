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
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution());
    }
    private static int solution() {
        List<Position> zeroIndex = new ArrayList<>();
        int answer = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j]== 0) zeroIndex.add(new Position(i, j));
            }
        }

        //0의 위치중 아무거나 3개 뽑아서 벽으로 만들기(중복은안됨)
        int size = zeroIndex.size();
        for(int i=0; i<size; i++) {
            for(int j=i+1; j<size; j++) {
                for(int k=j+1; k<size; k++) {
                    int x1 = zeroIndex.get(i).x;
                    int y1 = zeroIndex.get(i).y;
                    int x2 = zeroIndex.get(j).x;
                    int y2 = zeroIndex.get(j).y;
                    int x3 = zeroIndex.get(k).x;
                    int y3 = zeroIndex.get(k).y;

                    map[x1][y1] = 1;    //임의로 3군데 벽 세워보기
                    map[x2][y2] = 1;
                    map[x3][y3] = 1;

                    int[][] visited = new int[n][m];
                    for(int x=0; x<n; x++) {
                        for(int y=0; y<m; y++) {
                            //map을 탐색해서 바이러스를 만난다면 bfs로 0인곳에 바이러스 전파.
                            //visited 배열로 퍼트린 곳 체크.
                            if(map[x][y] == 2) bfs(x, y, visited);
                        }
                    }
                    int count = 0;  // 안전 영역 갯수 세기
                    for(int x=0; x<n; x++) {
                        for(int y=0; y<m; y++) {
                            if(map[x][y] == 0 && visited[x][y] == 0) count++;
                        }
                    }
                    answer = Math.max(count, answer);

                    map[x1][y1] = 0;    //벽으로 세워놨던 곳 다시 돌려놓기
                    map[x2][y2] = 0;
                    map[x3][y3] = 0;
                }
            }
        }
        return answer;
    }

    private static void bfs(int x, int y, int[][] visited) {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(x, y));
        visited[x][y] = 1;  //바이러스가 있는곳 방문처리
        while(!queue.isEmpty()) {   //바이러스 퍼트리기
            Position p = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(0<= nx && nx < n && 0<= ny && ny < m && map[nx][ny] == 0 && visited[nx][ny] == 0) {
                    visited[nx][ny] = 1;
                    queue.offer(new Position(nx, ny));
                }
            }
        }//end of while--
    }
}
