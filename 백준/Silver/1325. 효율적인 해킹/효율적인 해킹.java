import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int vertex;
    static int edge;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        vertex = Integer.parseInt(st.nextToken()); //노드 갯수
        edge = Integer.parseInt(st.nextToken()); //간선의 갯수

        graph.add(new ArrayList<>());
        for(int i=1; i<=vertex; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<edge; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // a가 b를 신뢰한다. -> 단방향 연결관계로 연결 받기
            graph.get(b).add(a);
        }

        StringBuilder sb = new StringBuilder();
        for(int x : solution()) {
            sb.append(x).append(" ");
        }
        System.out.println(sb);
    }

    private static int[] solution() {
        int[] answer = {};

        //해킹한 컴퓨터 수 기록할 배열 선언
        int[] record = new int[vertex + 1];

        //전체 노드(컴퓨터) 탐색
        int max = Integer.MIN_VALUE;
        for(int i=1; i<=vertex; i++) {
            int[] visited = new int[vertex+1];
            queue.offer(i);
            visited[i] = 1;

            int count = bfs(visited); //bfs돌리고 해킹한 컴퓨터 갯수 구하기
            max = Math.max(max, count); //최댓값 갱신
            record[i] = count;
        }

        //최대로 해킹할 수 있는 컴퓨터 갯수 세기
        int count = 0;
        for(int i=1; i<=vertex; i++) {
            if(record[i] == max) count++;
        }

        answer = new int[count];
        int idx = 0;
        for(int i=1; i<=vertex; i++) {
            if(record[i] == max) {
                answer[idx] = i;
                idx++;
            }
        }
        return answer;
    }

    private static int bfs(int[] visited) {
        // 해킹한 컴퓨터 갯수 세기
        int count = 1;
        while(!queue.isEmpty()) {
            int cur_vtx = queue.poll(); //현재 노드
            for(int i : graph.get(cur_vtx)) {
                if(visited[i] ==0) {
                    queue.offer(i);
                    visited[i] = 1;
                    count++;
                }
            }
        }
        return count;
    }
}
