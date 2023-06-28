import java.util.*;

public class Main {
    /**
     * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     * StringTokenizer st = new StringTokenizer(br.readLine());
     * int n = Integer.parseInt(br.readLine());
     */

    static int[] fibo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solution(n);
        System.out.println(fibo[n]);
    }

    private static void solution(int n) {
        fibo = new int[n+1];
        recursive(n);
    }

    private static int recursive(int n) {
        if(fibo[n] != 0) return fibo[n];
        if(n == 0) return fibo[n] = 0;
        else if(n == 1) return fibo[n] = 1;
        else if(n == 2) return fibo[n] = 1;
        else {
            return fibo[n] = recursive(n-1) + recursive(n-2);
        }
    }
}
