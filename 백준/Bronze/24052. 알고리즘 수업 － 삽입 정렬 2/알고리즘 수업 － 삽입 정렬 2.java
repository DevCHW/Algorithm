import java.util.*;

public class Main {
    static int count;

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] =sc.nextInt();
        }

        int[] answer = solution(n, k, arr);
        if (count < k) System.out.println(-1);
        else {
            for (int x : answer) {
                System.out.print(x + " ");
            }
        }
    }

    private static int[] solution(int n, int k, int[] arr) {
        for(int i=1; i<n; i++) {
            int prev = i-1;
            int tmp = arr[i];

            while(0 <= prev && tmp < arr[prev]) {
                arr[prev+1] = arr[prev];    //변경
                if (++count == k) return arr;
                prev--;

            }

            if (prev + 1 != i) {
                arr[prev+1] = tmp;  //변경
                if (++count == k) return arr;
            }
        }

        return arr;
    }
}