import java.util.*;
public class Main {
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }

    private static int solution(int number) {
        dp = new int[number+1];
        dp[0] = 0;
        dp[1] = 0;
        for(int i=2; i<=number; i++) {
            dp[i] = dp[i-1] + 1;
            if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
            if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
        }
        return dp[number];
    }
}