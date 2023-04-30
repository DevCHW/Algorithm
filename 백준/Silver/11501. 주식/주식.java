import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt(); //테스트케이스의 개수

        for(int i=0; i<t; i++) { //테스트케이스 만큼 실행.
            int n = sc.nextInt();
            int[] arr = new int[n];

            for(int j=0; j<n; j++) {
                arr[j] = sc.nextInt();
            }
            if(i != t-1) sb.append(solution(n, arr)).append("\n");
            else sb.append(solution(n, arr));
        }
        System.out.print(sb);
    }

    private static long solution(int n, int[] arr) {
        long answer = 0L;
        int max = Integer.MIN_VALUE;
        for(int i=n-1; i>=0; i--) {
            int cur_price = arr[i];
            if(cur_price > max) max = cur_price;
            else if(cur_price < max) answer += max-cur_price;
        }
        return answer;
    }
}
