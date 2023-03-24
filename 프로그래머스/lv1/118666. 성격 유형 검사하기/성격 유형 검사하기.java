import java.util.*;
class Solution {
    Map<Character, Integer> map = new HashMap<>();
    
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<survey.length; i++) {
            point(survey[i], choices[i]);
        }
        
        //1번지표(RT)
        if(map.getOrDefault('R',0) >= map.getOrDefault('T',0)) sb.append("R");
        else sb.append('T');
        
        //2번지표(CF)
        if(map.getOrDefault('C',0) >= map.getOrDefault('F',0)) sb.append("C");
        else sb.append('F');
        
        //3번지표(JM)
        if(map.getOrDefault('J',0) >= map.getOrDefault('M',0)) sb.append("J");
        else sb.append('M');
        
        //4번지표(AN)
        if(map.getOrDefault('A',0) >= map.getOrDefault('N',0)) sb.append("A");
        else sb.append('N');
        
        answer = sb.toString();
        return answer;
    }
    
    private void point(String str, int choice) {
        char a = str.charAt(0);
        char b = str.charAt(1);
        if(choice == 1) map.put(a, map.getOrDefault(a, 0) + 3);
            
        if(choice == 2) map.put(a, map.getOrDefault(a, 0) + 2);
            
        if(choice == 3) map.put(a, map.getOrDefault(a, 0) + 1);
                  
        if(choice == 5) map.put(b, map.getOrDefault(b, 0) + 1);
            
        if(choice == 6) map.put(b, map.getOrDefault(b, 0) + 2);
            
        if(choice == 7) map.put(b, map.getOrDefault(b, 0) + 3);
    }
}