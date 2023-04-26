import java.util.*;
class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        
        // 직각삼각형 채우기
        // 아래로 -> 옆으로 -> 대각선으로 반복하면서 채우기
        // 각 과정마다 n은 1씩 줄어든다.
        int row = -1;
        int col = 0;
        int num = 1;
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                if(i % 3 == 0) row++;   //아래로
                else if(i % 3 == 1) col++;  //옆으로
                else { //대각선으로
                    row--;
                    col--;
                }
                arr[row][col] = num++;
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(arr[i][j] == 0) break;
                else list.add(arr[i][j]);
            }
        }
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}