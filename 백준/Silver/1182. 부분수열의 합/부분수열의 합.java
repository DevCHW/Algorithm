import java.util.*;
public class Main {
    static int answer;
    static int[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        solution(n, s, arr);
        System.out.println(answer);
    }

    private static void solution(int n, int s, int[] arr) {
        visited = new int[n];
        recursive(0,0, s, arr);
        if(s == 0) answer-=1;
    }

    private static void recursive(int depth, int sum, int s, int[] arr) {
        if(depth == arr.length) {
            if(sum == s) answer++;
            return;
        }
        recursive(depth + 1, sum + arr[depth], s, arr);
        recursive(depth + 1, sum, s, arr);
    }
}
