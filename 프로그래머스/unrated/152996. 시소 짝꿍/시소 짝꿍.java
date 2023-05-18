import java.util.*;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<weights.length; i++) {
            map.put(weights[i], map.getOrDefault(weights[i], 0) + 1);
        }
        
        int[] keyArr = new int[map.size()];
        int[] valueArr = new int[map.size()];
        
        int idx=0;
        
        for(int x : map.keySet()) {
            //무게들을 넣어줌
            keyArr[idx] = x;
            //사람 수를 넣어줌
            valueArr[idx] = map.get(x);
            idx++;
        }
        
        for(int i=0; i<map.size()-1; i++) {
            if(valueArr[i] > 1) {
                answer += (long)valueArr[i] * (valueArr[i]-1) / 2;
            }
            
            int firstWeight = keyArr[i];
            for(int j=i+1; j<map.size(); j++) {
                int secondWeight = keyArr[j];
                if(check(firstWeight, secondWeight)) { //firstWeight와 secondWeight가 짝을 이룰 수 있다면.
                    //firstWeight를 가진 사람 수 * secondWeight을 가진 사람 수
                    answer += (long)valueArr[i] * valueArr[j];
                }
            }
        }
        
        if(valueArr[map.size()-1] > 1) {
            answer += (long) valueArr[map.size()-1] * (valueArr[map.size()-1]-1) / 2;
        }
        return answer;
    }
    
    private boolean check(int weight1, int weight2) {
        if(weight1 * 2 == weight2 * 3 ||
           weight1 * 2 == weight2 * 4 ||
           weight1 * 3 == weight2 * 2 ||
           weight1 * 3 == weight2 * 4 ||
           weight1 * 4 == weight2 * 2 ||
           weight1 * 4 == weight2 * 3 ) {
           return true; 
        } else {
            return false;
        }
    }
}