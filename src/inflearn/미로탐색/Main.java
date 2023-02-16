package inflearn.미로탐색;

import java.util.*;

public class Main {
    private static int answer;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[7][7];

        for(int i=0; i<7; i++) {    //2차원 배열 초기화
            for(int j=0; j<7; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        //방향벡터 정의
        dfs(0, 0, arr);
        System.out.print(answer);
    }

    private static void dfs(int x, int y, int[][] arr) {
        if(x == 6 && y == 6) answer++;
        else {
            for(int i=0; i<4; i++) {
                if(0 <= x && x < 7  && 0 <= y && y < 7 && arr[x][y] == 0) {
                    arr[x][y] = 1;    //방문처리
                    dfs(x + dx[i], y + dy[i], arr);
                    arr[x][y] = 0;    //방문처리 해제
                }
            }
        }
    }

}


