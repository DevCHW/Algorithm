import java.util.*;
public class Main {
    static int n;
    static int[] arr;
    static int start;
    static Queue<Integer> queue = new LinkedList<>();
    static int[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n+1];
        visited = new int[n+1];
        for(int i=1; i<=n; i++) arr[i] = sc.nextInt();
        start = sc.nextInt();

        System.out.println(solution());
    }

    private static int solution() {
        int answer = 0;
        bfs();  //bfs 돌려보기

        //방문처리된 곳 갯수 세기
        for(int i=1; i<=n; i++) {
            if(visited[i] == 1) answer++;
        }
        return answer;
    }

    private static void bfs() {
        queue.offer(start); //시작위치 넣기
        visited[start] = 1; //시작위치 방문처리

        while(!queue.isEmpty()) {
            int current_pos = queue.poll(); //현재 위치
            int left_move = current_pos - arr[current_pos]; //왼쪽으로 이동한 위치
            int right_move = current_pos + arr[current_pos]; //오른쪽으로 이동한 위치

            //왼쪽으로 이동한 위치가 돌다리 범위에 있으면 방문처리 하고 queue에 넣기
            if(left_move >=1 && left_move<= n) {
                visited[left_move] = 1;
                queue.offer(left_move);
            }
            //오른쪽으로 이동한 위치가 돌다리 범위에 있으면 방문처리 하고 queue에 넣기
            if(right_move >=1 && right_move<= n) {
                visited[right_move] = 1;
                queue.offer(right_move);
            }
        }
    }
}
