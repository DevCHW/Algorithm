package inflearn.조합의경우수;


import java.util.*;

public class Main {
    private static int[][] visited;
    private static int answer;
    private static int combination (int n, int r) {
        if(visited[n][r] != 0) return visited[n][r];
        if(n == r || r == 0) return 1;
        else {
            return visited[n][r] = combination(n-1, r-1) + combination(n-1, r);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        visited = new int[n+1][r+1];
        System.out.print(combination(n, r));
    }
}

