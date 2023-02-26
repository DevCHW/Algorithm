import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++) arr[i] = sc.nextInt();
        System.out.println(solution(n, arr));
    }

    private static int solution(int n, int[] arr){
        // n은 계단의 수
        // arr은 각 계단마다 점수 정보가 담긴 1차원 배열
        int[] dp = new int[n+1];
        dp[1] = arr[1];
        // n번째 계단으로 가는 경우의 수는 두가지가 있다.
        // n-2번째 계단에서 n번째 계단으로 가는 경우의 수
        // n-3번째 계단을 밟고, n-1번째 계단을 밟고, n번 계단으로 가는 경우의 수
        // 따라서 두가지 경우의 수의 점수를 구해보고, Math.max()로 최댓값을 dp[n]에 넣기

        if(n >= 2) {
            dp[2] = arr[1] + arr[2];
        }
        for(int i=3; i<=n; i++) {
            dp[i] = Math.max(dp[i-2],dp[i-3] + arr[i-1]) + arr[i];
        }
        return dp[n];
    }


}