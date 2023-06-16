import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int v1;
        int v2;
        int cost;

        Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
    /**
     * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     * StringTokenizer st = new StringTokenizer(br.readLine());
     * int n = Integer.parseInt(br.readLine());
     */
    static int[] arr;
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        while(true) {
            int m = sc.nextInt();   //집의 수(정점 수)
            int n = sc.nextInt();   //길의 수(간선 수)

            if(m == 0 && n == 0) break;
            List<Edge> info = new ArrayList<>();
            for(int i=0; i<n; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();

                info.add(new Edge(a, b, c));
            }
            System.out.println(solution(n, m, info));
        }
    }

    public static int solution(int n, int m, List<Edge> info) {
        int sum = 0;
        for(Edge edge : info) {
            sum += edge.cost;
        }

        //초기화
        arr = new int[m+1];
        for(int i=1; i<=m; i++) arr[i] = i;

        //정렬
        Collections.sort(info);

        for(Edge edge : info) {
            if(!isCycle(edge.v1, edge.v2)) {
                union(edge.v1, edge.v2);
                sum -= edge.cost;
            }
        }
        return sum;
    }

    private static boolean isCycle(int v1, int v2) {
        v1 = find(v1);
        v2 = find(v2);

        if (v1 == v2) {
            return true;
        } else {
            return false;
        }
    }

    private static int find(int v) {
        if (arr[v] == v) {
            return v;
        } else {
            return arr[v] = find(arr[v]);
        }
    }

    private static void union(int start, int end) {
        start = find(start);
        end = find(end);

        if (start != end) {
            arr[end] = start;
        }
    }
}
