import java.util.*;
public class Main {
    private static int[] board;
    private static int n;
    private static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n];
        solution();
        System.out.println(count);
    }

    private static void solution() {
        dfs(0);
    }

    private static void dfs(int depth) {
        if (depth == n) {
            count++;
            return;
        }

        for(int i=0; i<n; i++) {
            // board[열] = 행
            board[depth] = i;

            // 퀸을 놓을 수 있는 위치라면 재귀호출
            if (isPossible(depth)) {
                dfs(depth + 1);
            }
        }
    }

    private static boolean isPossible(int col) {
        for(int i=0; i<col; i++) {
            //해당 열의 행과 i열의 행이 일치할 경우( 같은 행에 존재할 경우)
            if (board[col] == board[i]) return false;

            // 대각선상에 놓여있는 경우
            // 열의 차와 행의 차가 같을 경우가 대각선에 놓여져 있는 경우다.
            if (Math.abs(col - i) == Math.abs(board[col] - board[i])) {
                return false;
            }
        }

        // 위의 검사를 통과하면 놓을 수 있는 위치.
        return true;
    }
}
