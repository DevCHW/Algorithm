import java.util.*;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        HashMap<Double, Integer> map = new HashMap<>();

        for(int key : weights) {
            double w = Double.valueOf(key);
            if(map.containsKey(w)){
                answer+=map.get(w);
            }
            map.put(w, map.getOrDefault(w, 0)+1);
            map.put(w*4/3,map.getOrDefault(w*4/3,0)+1);
            map.put(w*3/2,map.getOrDefault(w*3/2,0)+1);
            map.put(w*2,map.getOrDefault(w*2,0)+1);

        }
        return answer;
    }
}