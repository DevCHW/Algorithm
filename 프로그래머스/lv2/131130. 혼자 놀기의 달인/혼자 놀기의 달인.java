import java.util.*;
class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        
        int[] group = {-1, -1};
        for(int i=0; i<cards.length; i++) {
            if(cards[i] == -1) continue;    //방문처리된 곳
            
            int length = dfs(cards, i);
            if (group[0] < length) {
                group[1] = group[0];
                group[0] = length;
            } else if (group[1] < length) {
                group[1] = length;
            }
        }
        
        if(group[0] == cards.length) answer = 0;
        else {
            answer = group[0] * group[1];
        }
        
        return answer;
    }
    
    private int dfs(int[] cards, int idx) {
        if(cards[idx] == -1) {
            return 0;
        } else {
            int nextIdx = cards[idx]-1; //다음으로 갈 idx
            cards[idx] = -1; //방문처리

            return dfs(cards, nextIdx) + 1;
        }
    }
}