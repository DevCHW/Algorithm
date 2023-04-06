import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        //내림차순 정렬
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int x : tangerine) map.put(x, map.getOrDefault(x, 0) + 1);
        
        List<Integer> list = new ArrayList<>();
        
        for(int x : map.keySet()) list.add(map.get(x));
        Collections.sort(list, Collections.reverseOrder());
        
        for(int x : list) {
            answer++;
            k -= x;
            
            if (k <= 0) {
                break;
            }
        }
        
        return answer;
    }
}