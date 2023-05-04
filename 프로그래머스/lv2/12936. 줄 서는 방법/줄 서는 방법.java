import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        List<Integer> list = new ArrayList<>();
        long tmp = 1L;
        for(int i=1; i<=n; i++) {
            tmp *= i;
            list.add(i);
        }
        
        int[] answer = new int[n];
        k--;
        for(int i=0; i<n; i++) {
            tmp /= (n-i); //(n-i)!
            answer[i] = list.remove((int)(k/tmp));
            k = k%tmp;
        }
        return answer;
    }
}