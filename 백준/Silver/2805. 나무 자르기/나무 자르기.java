import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(n, m, arr));
    }

    private static int solution(int n, int m, int[] arr) {
        int answer = 0;

        Arrays.sort(arr);
        int start = 0;
        int end = arr[arr.length-1];
        while(start <= end) {
            long total = 0;
            int mid = (start+end)/2;
            //잘랐을 때 길이 계산
            for(int i=0; i<n; i++) {
                if(arr[i] > mid) total += arr[i] - mid;
            }
            if (total < m) {
                end = mid - 1;
            } else {
                answer = mid;
                start = mid + 1;
            }
        }
        return answer;
    }
}
