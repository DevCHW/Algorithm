import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n+1][3];
        for(int i=1; i<=n; i++) {
            for(int j=0; j<3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(n, arr));
    }
    private static int solution(int n, int[][] arr) {
//        arr[i][0] == i번째 집 빨강 비용.
//        arr[i][1] == i번째 집 초록 비용.
//        arr[i][2] == i번째 집 파랑 비용.
        for(int i=2; i<=n; i++) {
            arr[i][0] += Math.min(arr[i-1][1],arr[i-1][2]);
            arr[i][1] += Math.min(arr[i-1][0],arr[i-1][2]);
            arr[i][2] += Math.min(arr[i-1][0],arr[i-1][1]);
        }
        return Math.min(Math.min(arr[n][0],arr[n][1]),arr[n][2]);
    }
}