import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int n;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<=i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //문제의 핵심
        //int[][] dp 배열 초기화 한 뒤, 맨 아래 행만 복사한다.
        Integer[][] dp = new Integer[n][n];
        for(int i=n-1; i<n; i++) {
            for(int j=0; j<=i; j++) {
                dp[i][j] = arr[i][j];
            }
        }
        //dp배열은 Integer 객체배열로 활용하였는데, 이유는 int 배열로 쓰면 0이 default라서
        //문제에서 주어진 값의 범위가 0~9999라서 겹치기 때문,
        //하지만 이러한 객체배열은 int[] 배열의 메모리를 약 4배정도 잡아먹으니 자칫 잘못하면 메모리초과가 생길 수 있으니
        //재귀가 깊어지거나 입력값이 많을 땐 객체배열 말고 int배열을 활용하되, 0이 범위에 겹친다면 -1로 초기화하는 등의 방식을 써야 한다.
        //dp배열은 맨 아래 행을 복사한 후 위에서부터 재귀호출 하여 값을 하나하나씩 채우는 방식으로 한다.

        System.out.println(find(dp,0,0));
    }

    private static int find(Integer[][] dp, int depth, int idx) {
        //맨 아래까지 내려갔다면 리턴.
        if(depth == n-1) return dp[depth][idx];
        if(dp[depth][idx] == null) {
            dp[depth][idx] = arr[depth][idx] + Math.max(find(dp, depth + 1, idx), find(dp,depth+1,idx + 1));
        }
        return dp[depth][idx];
    }
}