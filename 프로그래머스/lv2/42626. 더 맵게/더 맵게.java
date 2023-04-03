import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        
        for(int x : scoville) {
            pQueue.offer(x);
        }
        
        while(!pQueue.isEmpty()) {
            int a = pQueue.poll();  //가장 작은 값 꺼내기
            if (a < K) { // 가장 작은 값이 K보다 작다면 섞기
                if (pQueue.size() < 1) return -1;
                int b = pQueue.poll();
                pQueue.offer(a + b*2);
                answer++;
            } else {
                break;
            }
        }
        return answer;
    }
}