package inflearn.응급실;

import java.util.*;

public class Main {
    static class People{
        int id;
        int priority;
        People(int id, int priority){
            this.id = id;
            this.priority = priority;
        }
    }

    public static int solution(int n, int m, int[] arr) {
        int answer = 0;
        Queue<People> queue = new LinkedList<>();

        for(int i=0; i<n; i++) {
            queue.offer(new People(i, arr[i]));
        }

        while(!queue.isEmpty()) {
            People tmp = queue.poll();
            for(People x : queue) {
                if(x.priority > tmp.priority) {
                    queue.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if(tmp != null) {
                answer++;   //진료횟수
                if(tmp.id == m) return answer;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(n, m, arr));
    }
}

