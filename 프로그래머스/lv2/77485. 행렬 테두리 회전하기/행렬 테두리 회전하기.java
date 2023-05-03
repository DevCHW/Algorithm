import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};
        int[][] graph = new int[rows][columns];
        int value = 1;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                graph[i][j] = value;
                value++;
            }
        }
        return rotate(graph, queries);
    }
    
    //회전 시키기
    //숫자만 
    public int[] rotate(int[][] graph, int[][] queries){
        int[] answer = new int[queries.length];
        int idx=0;

        for(int[] arr : queries){
            int x1 = arr[0]-1;
            int y1 = arr[1]-1;
            int x2 = arr[2]-1;
            int y2 = arr[3]-1;
            
            int tmp = graph[x1][y2];    //
            int min = tmp;
            
            //사각형이니 4번에 나눠서 회전시키고, 회전시킬때마다 최솟값 기록
            
            // 위쪽 숫자를 오른쪽으로 이동
            for(int i=y2-1; i>=y1; i--){
                min = Math.min(min, graph[x1][i]);
                graph[x1][i+1] = graph[x1][i];
            }

            // 왼쪽 숫자를 위로 이동 
            for(int i=x1+1; i<=x2; i++){
                min = Math.min(min, graph[i][y1]);
                graph[i-1][y1] = graph[i][y1];
            }

            // 아래 숫자를 왼쪽으로 이동
            for(int i=y1+1; i<=y2; i++){
                min = Math.min(min, graph[x2][i]);
                graph[x2][i-1] = graph[x2][i];
            }

            // 오른쪽 숫자를 아래로 다 이동
            for(int i=x2-1; i>=x1; i--){
                min = Math.min(min, graph[i][y2]);
                graph[i+1][y2] = graph[i][y2];
            }

            graph[x1+1][y2] = tmp;  //마지막 회전위치에 저장된 숫자 넣어주기
            answer[idx] = min;
            idx++;
        }

        return answer;
    }
}