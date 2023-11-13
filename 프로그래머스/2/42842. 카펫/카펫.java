import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int size = brown+yellow;
        
        int x = 3;
        int y = 3;
        
        // 먼저, 노랑색의 가로 세로를 구한다.
        for(int i=1; i<yellow; i++) {
            if (yellow % i == 0) { // i가 yellow의 약수라면
                x = i+2;
                y = (yellow/i)+2;
                if (x * y == size) break;
            }
        }
    
        int[] answer = {Math.max(x,y), Math.min(x,y)};
        return answer;
    }
}