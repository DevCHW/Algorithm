package inflearn.선택정렬;
import java.util.*;

public class Main {
    public static int[] solution(int n, int[] arr) {
        for(int i =0; i<n; i++) {
            int idx = i;
            for(int j= i+1; j<n; j++) {
                if(arr[j] < arr[idx]) idx = j;
            }
            int tmp = arr[idx];
            arr[idx] = arr[i];
            arr[i] = tmp;
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        for(int x : solution(n, arr)) {
            System.out.print(x + " ");
        }
    }
}
