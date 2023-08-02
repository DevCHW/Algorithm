import java.util.*;

public class Main {

    private static boolean flag;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] answer = solution(n, k, arr);
        if(flag) for(int x : answer) System.out.print(x + " ");
        else System.out.println(-1);
    }

    private static int[] solution(int n, int k, int[] arr) {
        int count = 0;
        for(int i=n-1; i>0; i--) {
            int indexMax = i;
            for(int j=0; j<i; j++) {
                if(arr[j] > arr[indexMax]) {
                    indexMax = j;
                }
            }

            if (i != indexMax) {
                // 교환
                int tmp = arr[i];
                arr[i] = arr[indexMax];
                arr[indexMax] = tmp;

                count++;    //카운팅

                if (count == k) {
                    flag = true;
                    break;
                }
            }
        }
        return arr;
    }
}
