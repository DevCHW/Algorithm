import java.util.*;
class Solution {
    char[] lib = {'A','E','I','O','U'};
    List<String> list = new ArrayList<>();    
    public int solution(String word) {
        int answer = 0;
       
        recursive(0, "", word);
        for(String x : list) {
            if(x.equals(word)) break;
            answer++;
        }
        return answer;
    }
    
    public void recursive(int depth, String tmp, String word) {
        list.add(tmp);
        if(depth == 5) return;
        else {
            for(int i=0; i<lib.length; i++) {
                recursive(depth + 1, tmp + lib[i], word);
            }
        }
    }
}