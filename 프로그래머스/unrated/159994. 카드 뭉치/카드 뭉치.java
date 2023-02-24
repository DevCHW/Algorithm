import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        boolean flag = true;
        
        int p1 = 0;
        int p2 = 0;
        for(String x : goal) {
            String str1 = "";
            String str2 = "";
            if(p1 < cards1.length) {
                str1 = cards1[p1];
            }
            if(p2 < cards2.length) {
                str2 = cards2[p2];
            }
            if(x.equals(str1)) p1++;
            else if(x.equals(str2)) p2++;
            else {
                flag = false;
                break;
            }

        }
        if(flag) answer = "Yes";
        else answer = "No";
        return answer;
    }
}