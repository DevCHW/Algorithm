package inflearn.바둑이승차;

import java.util.*;

public class Main {
    private static int c; //트럭이 태울 수 있는 무게
    private static int n; //바둑이 마릿수
    private static int answer;  //정답



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt();
        n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        dfs(0, 0, arr);
        System.out.print(answer);
    }

    private static void dfs(int level, int sum, int[] arr) {
        if(sum > c) return;
        if(level == n) {
            answer = Math.max(answer,sum);
        } else {
            dfs(level+1, sum + arr[level], arr);
            dfs(level +1 , sum, arr);
        }
    }
}



