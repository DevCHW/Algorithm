import java.util.*;
public class Main {
    public static void main(String[] args) {
        /**
         *
         *           1    |    2   |    3
         *----------------------------------------------
         *   0  |    1    |   10   |    55
         *   1  |    1    |    9   |    45
         *   2  |    1    |    8   |
         *   3  |    1    |    7   |
         *   4  |    1    |    6   |
         *   5  |    1    |    5   |
         *   6  |    1    |    4   |
         *   7  |    1    |    3   |
         *   8  |    1    |    2   |
         *   9  |    1    |    1   |
         *
         *  // dp[i][j] += dp [i-1][k];
         */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }

    private static int solution(int n) {
        int[][] dp = new int[n+1][10];  //dp[n][k] 는 n개의 자릿수 숫자 중 마지막 숫자가 k일 때의 만들 수 있는 수
        //초기 값 설정
        for(int i=0; i<10; i++) {
            dp[1][i] = 1;   //1자리의 숫자는 각 숫자들을 가지고 1개씩 만들 수 있음
        }

        for(int i=2; i<=n; i++) {
            for(int j=0; j<10; j++) {
                for(int k=j; k<10; k++) {   //k는 j보다 크거나같은 수.
                    dp[i][j] += (dp[i-1][k] % 10007);
                }
            }
        }

        int answer = Arrays.stream(dp[n]).sum() % 10007;
        return answer;
    }
}
