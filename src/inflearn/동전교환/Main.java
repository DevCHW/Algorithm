package inflearn.동전교환;


import java.util.*;

public class Main {
    private static int n;   //동전종류의 수
    private static int m;   //거슬러줄 돈
    private static boolean flag;
    private static int[] used;
    private static int answer = Integer.MAX_VALUE;

    public static void dfs(int level, int sum, Integer[] arr) {
        if(sum > m) return;
        if(level >= answer) return;
        if(sum == m){
            answer = Math.min(answer, level);
        }else{
            for(int i=0; i<n; i++) {
                dfs(level + 1, sum + arr[i], arr);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Integer[] coins = new Integer[n];
        for(int i=0; i<n; i++) {
            coins[i] = sc.nextInt();
        }
        m = sc.nextInt();   //거슬러 줄 금액
        Arrays.sort(coins, Collections.reverseOrder());

        dfs(0, 0, coins);
        System.out.println(answer);
    }
}

