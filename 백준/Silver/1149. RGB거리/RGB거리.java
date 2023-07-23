import java.util.*;

public class Main {

    private static int[][] dp;
    private static final int RED = 0;
    private static final int GREEN = 1;
    private static final int BLUE = 2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] info = new int[n][3];
        for(int i=0; i<n; i++) {
            int red = sc.nextInt();
            int green = sc.nextInt();
            int blue = sc.nextInt();
            info[i][RED] = red;
            info[i][GREEN] = green;
            info[i][BLUE] = blue;
        }

        System.out.println(solution(n,info));
    }

    private static int solution(int n, int[][] info) {
        dp = new int[n][3];    //비용의 최솟값을 저장하면서 뻗기

        dp[0][RED] = info[0][RED];
        dp[0][GREEN] = info[0][GREEN];
        dp[0][BLUE] = info[0][BLUE];

        int redMin = dfs(n, RED, info);
        int greenMin = dfs(n, GREEN, info);
        int blueMin = dfs(n, BLUE, info);

        return Math.min(Math.min(redMin, greenMin), blueMin);
    }

    private static int dfs(int n, int color, int[][] info) {
        if(dp[n-1][color] == 0) {
            if(color == RED) {
                dp[n-1][RED] = Math.min(dfs(n-1, GREEN, info), dfs(n-1, BLUE, info)) + info[n-1][RED];
            } else if (color == GREEN) {
                dp[n-1][GREEN] = Math.min(dfs(n-1, RED, info), dfs(n-1, BLUE, info)) + info[n-1][GREEN];
            } else {
                dp[n-1][BLUE] = Math.min(dfs(n-1, RED, info), dfs(n-1, GREEN, info)) + info[n-1][BLUE];

            }
        }

        return dp[n-1][color];
    }
}