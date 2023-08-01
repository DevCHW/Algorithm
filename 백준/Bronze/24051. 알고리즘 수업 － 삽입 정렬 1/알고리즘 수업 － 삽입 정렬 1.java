import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(n, k, arr));
    }

    private static int solution(int n, int k, int[] arr) {
        int answer = 0;

        for(int i=1; i<n; i++) {
            int prev = i-1;
            int tmp = arr[i];

            while( (prev >= 0) && (arr[prev] > tmp) ) {
                arr[prev+1] = arr[prev];
                answer++;
                if(answer == k) return arr[prev];

                prev--;
            }
            if(prev+1 != i) {
                arr[prev+1] = tmp;
                answer++;
            }
        }
        return -1;
    }
}
