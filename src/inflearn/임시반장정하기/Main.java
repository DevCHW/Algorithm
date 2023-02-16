package inflearn.임시반장정하기;
import java.util.*;

public class Main {
    public static int solution(int n, int[][] arr) {
        int answer = 0;
        int max = Integer.MIN_VALUE;
        for(int i=1; i<n+1; i++) {
            int count = 0;
            for(int j=1; j<n+1; j++) {
                for(int k=1; k<6; k++) {
                    if(arr[i][k] == arr[j][k]) {
                        count++;
                        break;
                    }
                }
            }
            if(max < count) {
                max = count;
                answer = i;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //학생 수
        int[][] arr = new int[n+1][6];
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<6; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(n, arr));
    }
}
