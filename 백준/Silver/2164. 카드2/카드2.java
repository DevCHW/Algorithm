import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n; i++) queue.offer(i);
        System.out.println(solution(n, queue));
    }
    private static int solution(int n, Queue<Integer> queue) {
        int count = 0;
        while(queue.size() > 1) {
            count++;
            if(count % 2 == 0) {
                int tmp = queue.poll();
                queue.offer(tmp);
            } else {
                queue.poll();
            }
        }
        if(!queue.isEmpty()) return queue.poll();
        return 0;
    }
}
