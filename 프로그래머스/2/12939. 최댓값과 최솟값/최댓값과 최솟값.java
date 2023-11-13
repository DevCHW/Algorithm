import java.util.*;
class Solution {
    public String solution(String s) {
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(String x : s.split(" ")) {
            int number = Integer.parseInt(x);
            
            if (number > max) {
                max = number;
            } 
            
            if (number < min) {
                min = number;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(min));
        sb.append(" ");
        sb.append(String.valueOf(max));
        String answer = sb.toString();
        return answer;
    }
}