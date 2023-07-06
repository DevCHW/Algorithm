import java.util.*;

class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new char[n][n];

        for(int i=0; i<n; i++) {
            String tmp = sc.next();
            for(int j=0; j<n; j++) {
                arr[i][j] = tmp.charAt(j);
            }
        }

        System.out.println(solution(n));
    }

    private static int solution(int n) {
        int answer = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                char current_color = arr[i][j];
                int count = simulation(i, j, n, current_color);
                answer = Math.max(answer, count);
            }
        }
        return answer;
    }

    /**
     * 자리바꾸기 시뮬레이션 돌리기
     */
    private static int simulation(int x, int y, int length, char current_color) {
        int result = 0;
        for(int k=0; k<4; k++) {
            int nx = x+dx[k];
            int ny = y+dy[k];
            if(nx >= 0 && nx < length && ny >= 0 && ny < length && current_color != arr[nx][ny]) {
                char next_color = arr[nx][ny];

                // 자리바꾸기
                arr[x][y] = next_color;
                arr[nx][ny] = current_color;

                // 갯수 세기
                int count = count(length);
                result = Math.max(result, count);

                // 자리 원상복구
                arr[x][y] = current_color;
                arr[nx][ny] = next_color;
            }
        }
        return result;
    }

    /**
     * 갯수 세기
     */
    private static int count(int length) {
        int max_count = 0;

//        print(length);

        for(int i=0; i<length; i++) {
            char row = arr[i][0];
            char col = arr[0][i];
            int row_count = 1;
            int col_count = 1;

            for(int j=1; j<length; j++) {
                if(row == arr[i][j]) row_count++;
                else {
                    max_count = Math.max(max_count, row_count);
                    row = arr[i][j];
                    row_count = 1;
                }

                if(col == arr[j][i]) col_count++;
                else {
                    max_count = Math.max(max_count, col_count);
                    col = arr[j][i];
                    col_count = 1;
                }
            }
            max_count = Math.max(max_count, row_count);
            max_count = Math.max(max_count, col_count);
        }
        return max_count;
    }

    /**
     * 확인용
     */
    private static void print(int length) {
        for(int i = 0; i< length; i++) {
            for(int j = 0; j< length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}