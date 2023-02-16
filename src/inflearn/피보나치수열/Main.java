package inflearn.피보나치수열;

import java.util.*;
public class Main {
    static int n;
    static int[] fibo;
    public int dfs(int n) {
        if(n == 1) return fibo[n] = 1;
        else if(n == 2) return fibo[n] = 1;
        else {
            return fibo[n] = dfs(n-2) + dfs(n-1);
        }
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        fibo = new int[n + 1];
        T.dfs(n);
        for(int i=1; i<=n; i++) System.out.print(fibo[i] + " ");
    }
}

