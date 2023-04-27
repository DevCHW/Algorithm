import java.util.*;

class Point implements Comparable<Point> {
    int x, y, dist;

    Point(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    @Override
    public int compareTo(Point o) {
        if (this.dist == o.dist) {
            if (this.x == o.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }
        return this.dist - o.dist;
    }
}

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int n, sharkX, sharkY, sharkSize = 2, eatCount = 0, totalTime = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            List<Point> fishList = new ArrayList<>();
            Queue<Point> q = new LinkedList<>();
            q.offer(new Point(sharkX, sharkY, 0));
            visited[sharkX][sharkY] = true;

            while (!q.isEmpty()) {
                Point cur = q.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    if (visited[nx][ny]) continue;
                    if (map[nx][ny] > sharkSize) continue;

                    visited[nx][ny] = true;

                    if (map[nx][ny] > 0 && map[nx][ny] < sharkSize) {
                        fishList.add(new Point(nx, ny, cur.dist + 1));
                    }

                    q.offer(new Point(nx, ny, cur.dist + 1));
                }
            }

            if (fishList.size() == 0) break;

            Collections.sort(fishList);

            Point fish = fishList.get(0);
            sharkX = fish.x;
            sharkY = fish.y;
            map[sharkX][sharkY] = 0;

            eatCount++;
            if (eatCount == sharkSize) {
                sharkSize++;
                eatCount = 0;
            }

            totalTime += fish.dist;
            visited = new boolean[n][n];
        }

        System.out.println(totalTime);
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
}