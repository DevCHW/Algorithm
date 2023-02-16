package inflearn.합이같은부분집합;

import java.util.*;

public class Main {
    private static String answer = "NO";
    private static int n, total = 0;
    private static boolean flag = false;
    private static void dfs(int level, int sum, int[] arr) {
        if(flag) return;
        if(sum > total/2) return;
        if(level == n) {
            if(total - sum == sum) {
                answer="YES";
                flag = true;
            }
        } else {
            dfs(level + 1, sum+arr[level], arr);
            dfs(level + 1, sum, arr);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }
        dfs(0, 0, arr);
        System.out.println(answer);
    }

}


