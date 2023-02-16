package inflearn.이분탐색;


import java.util.*;

public class Main {
    public static int solution(int n, int m, int[] arr) {
        Arrays.sort(arr);
        int answer = -1;
        int lt = 0;
        int rt = arr.length-1;
        while(lt<=rt) {
            int mid = (lt+rt) / 2;
            if(m == arr[mid]) {
                answer = mid+1;
                break;
            }
            if(m < arr[mid]) rt = mid-1;
            else lt = mid+1;
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print(solution(n, m, arr));
    }
}

