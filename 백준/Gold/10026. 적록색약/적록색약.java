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
    static char[][] image;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        image = new char[n][n];
        for(int i=0; i<n; i++) {
            String str = sc.next();
            int j=0;
            for(char x : str.toCharArray()) {
                image[i][j] = x;
                j++;
            }
        }
        System.out.println(solution());
    }

    private static String solution() {
        int[][] visited = new int[n][n];
        int nomalCnt = 0;
        int specialCnt = 0;
        boolean flag = false;
        //일반사람 카운트하기
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(visited[i][j] == 0) {
                    nomalCnt++;
                    bfs(i, j, visited, image[i][j],flag);
                }
            }
        }

        String answer = nomalCnt + " ";
        flag = true;
        for(int[] x : visited) {
            Arrays.fill(x,0);
        }
        //적록색약 카운트하기
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(visited[i][j] == 0) {
                    specialCnt++;
                    bfs(i, j, visited, image[i][j], flag);
                }
            }
        }
        answer += specialCnt;
        return answer;
    }

    private static void bfs(int x, int y, int[][] visited, char tmp, boolean flag) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(x, y));
        visited[x][y] = 1;

        while(!queue.isEmpty()) {
            Position p = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(!flag) {
                    if(0<= nx && nx <n && 0<= ny && ny < n && visited[nx][ny] == 0 && image[nx][ny] == tmp) {
                        visited[nx][ny] = 1;
                        queue.offer(new Position(nx, ny));
                    }
                } else {    //적록색약 따지기
                    if(tmp == 'R' || tmp == 'G') {  //R이나 G가 들어왔다면
                        if(0<= nx && nx <n && 0<= ny && ny < n && visited[nx][ny] == 0 && (image[nx][ny] == 'R' || image[nx][ny] == 'G')) {
                            visited[nx][ny] = 1;
                            queue.offer(new Position(nx, ny));
                        }
                    } else {
                        if(0<= nx && nx <n && 0<= ny && ny < n && visited[nx][ny] == 0 && image[nx][ny] == tmp) {
                            visited[nx][ny] = 1;
                            queue.offer(new Position(nx, ny));
                        }
                    }
                }

            }//end of for--
        }//end of while--
    }

}
