import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Set<Integer> kind1 = new HashSet<>();
        Map<Integer,Integer> kind2 = new HashMap<>();
        
        //setR에는 0~topping배열의 길이만큼 값을 다 넣어주기
        for(int i=0; i<topping.length; i++) {
            kind2.put(topping[i], kind2.getOrDefault(topping[i], 0) + 1);
        }
        
        for(int i=0; i<topping.length; i++) {
            kind1.add(topping[i]);
            kind2.put(topping[i], kind2.get(topping[i]) - 1);
            
            if(kind2.get(topping[i]) == 0) kind2.remove(topping[i]);
            
            if(kind1.size() == kind2.size()) answer++;
        }
        return answer;
    }
}