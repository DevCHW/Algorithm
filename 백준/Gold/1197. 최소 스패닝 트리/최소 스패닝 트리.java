import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int cost;

        Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
    static int[] arr;

    /**
     * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     * StringTokenizer st = new StringTokenizer(br.readLine());
     * int n = Integer.parseInt(br.readLine());
     */
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        List<Edge> info = new ArrayList<>();
        for(int i=0; i<e; i++) {
            int a = sc.nextInt();   // a번 정점
            int b = sc.nextInt();   // b번 정점
            int c = sc.nextInt();   // 가중치 c

            info.add(new Edge(a, b, c));
        }

        System.out.println(solution(v, e, info));
    }

    public static int solution(int v, int e, List<Edge> info) {
        int answer = 0;

        arr = new int[v+1];
        // 먼저, 모든 노드가 자기 자신을 가르키도록 초기화
        for (int i=1; i<=v; i++) {
            arr[i] = i;
        }

        // 가중치를 기준으로 정렬
        Collections.sort(info);
        
        for (int i=0; i<e; i++) {
            Edge edge = info.get(i);
            if (!isCycle(edge.start, edge.end)) {   //싸이클이 아니라면
                union(edge.start, edge.end);    //root 정점을 최초 출발지로 바꿔주기
                answer += edge.cost;    //비용 추가
            }
        }
        return answer;
    }

    public static boolean isCycle(int v1, int v2) {
        v1 = find(v1);
        v2 = find(v2);

        if (v1 == v2) { //두 정점의 root 정점이 같다면 싸이클 형성.
            return true;
        } else {
            return false;
        }
    }

    public static int find(int v) {
        if (arr[v] == v) {  //자기 자신을 가르키고 있다면
            return v;
        } else {    //자기 자신을 가르키고 있지 않다면
            return arr[v] = find(arr[v]);   //재귀 적으로 호출하여 root 정점으로 교체
        }
    }

    public static void union(int start, int end) {
        start = find(start);
        end = find(end);
        if (start != end) {
            arr[end] = start;   //도착지를 출발 정점지로 교체
        }
    }
}
