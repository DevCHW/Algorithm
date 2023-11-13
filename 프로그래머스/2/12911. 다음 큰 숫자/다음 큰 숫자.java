import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        int next = n+1;
        int nCountOne = countOne(Integer.toBinaryString(n));
        while(true) {
            int count = countOne(Integer.toBinaryString(next));
            if (nCountOne == count) {
                answer = next;
                break;
            }
            next++;
        }
        return answer;
    }
    
    private int countOne(String s) {
        int count = 0;
        for(char x : s.toCharArray()) {
            if (x == '1') count++;
        }
        return count;
    }
}