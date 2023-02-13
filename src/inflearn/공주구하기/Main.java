package inflearn.공주구하기;
import java.util.*;

public class Main {
    private static int solution(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n; i++) {
            queue.offer(i);
        }
        while(!(queue.size() == 1)) {
            for(int i=0; i<2; i++){
                int x = queue.poll();
                queue.offer(x);
            }
            queue.poll();
        }
        int answer = queue.poll();
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(solution(n, k));
    }

}


