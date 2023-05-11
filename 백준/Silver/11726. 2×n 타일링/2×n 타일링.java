import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(solution(n));
    }

    private static int solution(int n) {
        //두가지의 방법
        // 옆으로 세우거나(1x2) , 눕히거나(2x1)
        // n이 1 -> 1가지
        // n이 2 -> 2가지
        // n이 3 -> 3가지
        // n이 4 -> 5가지
        // n이 5 -> 8가지

        // 점화식
        // dp[i] = dp[i-1] + dp[i-2];
        int[] dp = new int[1001];
        dp[1] =1;
        dp[2] =2;

        for(int i=3; i<=n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }
        return dp[n] % 10007;
    }
}
