import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<want.length; i++) {
            map.put(want[i], number[i]);
        }
        
        Map<String, Integer> map2 = new HashMap<>();
        //첫 9일치 계산시키기
        for(int i=0; i<9; i++) {
            map2.put(discount[i], map2.getOrDefault(discount[i], 0) + 1);
        }
        
        int lt=0;
        
        //오른쪽 넣고 -> 검증 -> 왼쪽 빼기
        for(int rt=9; rt<discount.length; rt++) {
            String fruit = discount[rt];
            map2.put(fruit, map2.getOrDefault(fruit, 0) + 1);
            
            if(map.equals(map2)) answer++; //검증 후 일치하면 answer 증가
            
            map2.put(discount[lt], map2.get(discount[lt]) - 1);
            if(map2.get(discount[lt]) == 0) map2.remove(discount[lt]);
            
            lt++;
        }
        
        return answer;
    }
    
    public boolean validate(Map<String,Integer> map) {
        for(int x : map.values()) {
            if(x != 0) return false;
        }
        
        return true;
    }
}