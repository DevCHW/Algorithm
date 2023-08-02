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
        if(flag) {
            for(int x : answer) System.out.print(x + " ");
        } else {
            System.out.println(-1);
        }
    }

    private static int[] solution(int n, int k, int[] arr) {
        int[] answer = new int[2];
        int count = 0;

        for(int i=n-1; i>0; i--) {
            int indexMin = i;
            for(int j=0; j<i; j++) {
                if(arr[j] > arr[indexMin]) {
                    indexMin = j;
                }
            }
            if (indexMin != i) {
                int tmp = arr[i];
                arr[i] = arr[indexMin];
                arr[indexMin] = tmp;

                count++;
                if(count == k) {
                    flag = true;
                    answer[0] = arr[indexMin];
                    answer[1] = arr[i];
                }
            }
        }

        return answer;
    }
}
