import java.util.*;
public class Main {
    static class Balloon {
        int idx;
        int dist;
        Balloon(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];

        for(int i=1; i<=n; i++) {
            arr[i] = sc.nextInt();
        }
        solution(n, arr);
    }

    public static int[] solution(int n, int[] arr) {
        int[] answer = new int[n];
        Queue<Balloon> queue = new LinkedList<>();

        for(int i=1; i<=n; i++) {
            queue.offer(new Balloon(i, arr[i]));
        }

        //1번풍선 꺼내기
        Balloon balloon = queue.poll();
        answer[0] = 1;

        while(!queue.isEmpty()) {
            int cur = balloon.idx;   //현재위치
            int dist = balloon.dist;
            int pos = (Math.abs(cur + dist) % queue.size());   //가야 할 위치
            for(int i=0; i<pos; i++) {

            }
        }
        return answer;
    }
}
