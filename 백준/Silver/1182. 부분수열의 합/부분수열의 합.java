import java.util.*;

public class Main {

    static int answer;

    /**
     * 입,출력
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        solution(n, s, arr);
        print(answer);
    }

    private static void solution(int n, int s, int[] arr) {
        recursive(0, n, s, arr, 0);
        if(s == 0) answer--;
    }

    private static void recursive(int depth, int n, int s, int[] arr, int number) {
        if (depth == n) {
            if(number == s) {
                answer++;
            }
        } else {
            recursive(depth+1, n, s, arr, number+arr[depth]);
            recursive(depth+1, n, s, arr, number);
        }
    }

    /**
     * print() 구현
     */
    private static void print(String str) {
        System.out.println(str);
    }

    /**
     * print() 구현
     */
    private static void print(int number) {
        System.out.println(number);
    }
}
