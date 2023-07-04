import java.util.*;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        // 무게배열의 길이는 10만까지 이지만, 무게는 100부터 1000까지만 존재하므로 중복을 제거한다면 최대 길이는 900이므로 중복을 제거하여 map에 담아준다.
        
        // key는 무게, value는 사람 수
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<weights.length; i++) {
            map.put(weights[i], map.getOrDefault(weights[i], 0) + 1);
        }
        
        int size = map.size();
        // 다시 무게배열, 사람 수 배열로 쪼갠다.
        int[] weightArr = new int[size];
        int[] countArr = new int[size];
        
        int idx = 0;
        for(int key : map.keySet()) {
            weightArr[idx] = key;
            countArr[idx] = map.get(key);
            idx++;
        }
        
        
        for(int i=0; i<size; i++) {
            if(countArr[i] > 1) {
                answer += (long) countArr[i] * (countArr[i]-1) / 2;
            }
            
            int weight1 = weightArr[i]; // 무게 1 선언
            int people1 = countArr[i]; //무게1을 가진 사람 수 선언
            for(int j=i+1; j<size; j++) {
                int weight2 = weightArr[j]; // 무게 2 선언
                
                if (check(weight1, weight2)) { //무게 1과 무게2가 짝꿍이 될 수 있다면
                    int people2 = countArr[j]; //무게2를 가진 사람 수
                    
                    answer += (long) people1 * people2; //둘을 곱하여 answer에 누적.
                }
            }
        }
        
        
        return answer;
    }
    
    private boolean check(int weight1, int weight2) {
        if(weight1*2 == weight2*3 ||
           weight1*2 == weight2*4 ||
           weight1*3 == weight2*2 ||
           weight1*3 == weight2*4 ||
           weight1*4 == weight2*2 ||
           weight1*4 == weight2*3) {
            return true;
        } else {
            return false;
        }
    }
}