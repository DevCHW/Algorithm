import java.util.*;
public class Main {
    static Integer[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        dp = new Integer[41][2];
        dp[0][0] = 1;   //n=0 일 때의 0 호출 횟수
        dp[0][1] = 0;   //n=0 일 때의 1 호출 횟수
        dp[1][0] = 0;   //n=1 일 때의 0 호출 횟수
        dp[1][1] = 1;   //n=1 일 때의 1 호출 횟수
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++) {
            int n = sc.nextInt();
            fibo(n);
            sb.append(dp[n][0]);
            sb.append(" ");
            sb.append(dp[n][1]);
            if(i != t-1) {
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
    private static Integer[] fibo(int n) {
        // n에대한 0, 1의 호출 횟수가 없을 때(탐색하지 않은 값일 때)
        if(dp[n][0] == null || dp[n][1] == null) {
            dp[n][0] = fibo(n-1)[0] + fibo(n-2)[0];
            dp[n][1] = fibo(n-1)[1] + fibo(n-2)[1];
        }
        return dp[n];
    }

}