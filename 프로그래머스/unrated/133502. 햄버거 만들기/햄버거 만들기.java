import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for(int x : ingredient) {
            list.add(x);
            if(list.size() >= 4) {
                int s = list.size();
                if(list.get(s-1) == 1 &&
                list.get(s-2) == 3 &&
                list.get(s-3) == 2 &&
                list.get(s-4) == 1) {
                    answer++;
                    list.remove(s-1);
                    list.remove(s-2);
                    list.remove(s-3);
                    list.remove(s-4);
                }
            }
        }
        return answer;
    }
}