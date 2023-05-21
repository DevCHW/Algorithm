import java.util.*;
public class Main {
    static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();   //세로
        m = sc.nextInt();   //가로
        int[][] graph = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(graph));
    }
    private static int solution(int[][] graph) {
        int answer = Integer.MIN_VALUE;
        List<Position> zeroIndexList = new ArrayList<>();  //0인 위치를 기록할 List 선언
        Queue<Position> virusIndex = new LinkedList<>();   //바이러스의 위치를 기록할 queue
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if (graph[i][j] == 0) { //빈공간이라면 기록
                    zeroIndexList.add(new Position(i, j));
                }
                if (graph[i][j] == 2) { //바이러스라면 기록
                    virusIndex.offer(new Position(i, j));
                }
            }
        }
        // 모든 조합수에 대하여 일단 3개 벽을 세워보기
        int len = zeroIndexList.size();
        for(int i=0; i<len; i++) {
            for(int j=i+1; j<len; j++) {
                for(int k=j+1; k<len; k++) {
                    //벽 세울 위치 3개 뽑기
                    Position wall1 = zeroIndexList.get(i);
                    Position wall2 = zeroIndexList.get(j);
                    Position wall3 = zeroIndexList.get(k);

                    //벽 세우기
                    graph[wall1.x][wall1.y] = 1;
                    graph[wall2.x][wall2.y] = 1;
                    graph[wall3.x][wall3.y] = 1;

                    //bfs로 바이러스 퍼트리기
                    int[][] visited = new int[n][m]; //방문배열 만들기
                    answer = Math.max(answer, bfs(graph, visited, virusIndex)); //바이러스 퍼트려보고 안전영역 맥스값 갱신

                    //벽으로 만들었던 것 원상복구 시키기.
                    graph[wall1.x][wall1.y] = 0;
                    graph[wall2.x][wall2.y] = 0;
                    graph[wall3.x][wall3.y] = 0;
                }
            }
        }
        return answer;
    }

    private static int bfs(int[][] graph, int[][] visited, Queue<Position> virusIndex) {
        Queue<Position> queue = new LinkedList<>();
        for(Position p : virusIndex) queue.offer(p);  //바이러스 위치 복사

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while(!queue.isEmpty()) {
            Position pos = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny< m && graph[nx][ny] == 0 && visited[nx][ny] == 0) {   //graph 상에서 빈공간(0)이고 방문하지 않은곳이라면,
                    queue.offer(new Position(nx, ny));
                    visited[nx][ny] = 1;    //방문 처리
                }
            }
        }
        int count = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(graph[i][j] == 0 && visited[i][j] == 0) {    //graph 상에서 안전영역(0)이고, 바이러스가 퍼지지 않은 곳이라면
                    count++;
                }
            }
        }
        return count;
    }
}
