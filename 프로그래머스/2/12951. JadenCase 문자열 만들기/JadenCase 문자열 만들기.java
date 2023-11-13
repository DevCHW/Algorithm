import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        boolean first = true;
        for(char x : s.toCharArray()) {
            if (x == ' ') {
                sb.append(" ");
                first = true;
                continue;
            }
            
            if (first) {
                sb.append(String.valueOf(x).toUpperCase());
                first = false;
            } else {
                sb.append(String.valueOf(x).toLowerCase());
            }
            
        }
        return sb.toString();
    }
}