import java.util.*;

public class Main {
    static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // n 입력받기
        int n = sc.nextInt();

        // m 입력받기
        int m = sc.nextInt();

        // board 입력받기
        char[][] board = new char[n][m];
        for(int i=0; i<n; i++) {
            String str = sc.next();
            for(int j=0; j<m; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        System.out.println(solution(n, m, board));
    }

    private static int solution(int n, int m, char[][] board) {
        int answer = Integer.MAX_VALUE;

        for(int i=0; i<n-7; i++) {
            for(int j=0; j<m-7; j++) {
                answer = Math.min(answer, getCount(i, j, board));
            }
        }
        return answer;
    }

    private static int getCount(int x, int y, char[][] board) {
        int count = 0;

        char currentColor = board[x][y];

        for(int i=x; i<x+8; i++) {
            for(int j=y; j<y+8; j++) {
                if(board[i][j] != currentColor) {
                    count++;
                }
                currentColor = change(currentColor);
            }
            currentColor = change(currentColor);
        }
        return Math.min(count, 64 - count);
    }

    private static char change(char currentColor) {
        if(currentColor == 'W') {
            return 'B';
        } else {
            return 'W';
        }
    }


}
