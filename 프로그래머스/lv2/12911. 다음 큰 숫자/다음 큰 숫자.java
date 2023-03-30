import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int tmp = n;
        while(true) {
            tmp++;
            char[] arr1 = Integer.toBinaryString(tmp).toCharArray();
            char[] arr2 = Integer.toBinaryString(n).toCharArray();
            int count1 = 0;
            int count2 = 0;
            for(char x : arr1) {
                if(x == '1') count1++;
            }
            for(char x : arr2) {
                if(x == '1') count2++;
            }
            
            if(count1 == count2) {
                answer = tmp;
                break;
            }
        }
        return answer;
    }
}