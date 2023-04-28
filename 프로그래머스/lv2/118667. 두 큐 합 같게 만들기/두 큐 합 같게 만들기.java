import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0L;
        long sum2 = 0L;
        Queue<Integer> queueOne = new LinkedList<>();
        Queue<Integer> queueTwo = new LinkedList<>();
        
        // queue1, queue2의 합 구하기
        for(int i=0; i<queue1.length; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];
            
            queueOne.offer(queue1[i]);
            queueTwo.offer(queue2[i]);
        }
        
        //최대 작업 수 -> 모든 queue의 원소를 갈아치웠을 때
        int max_count = queue1.length*2;
        int queue1_cnt = 0;
        int queue2_cnt = 0;
        
        while(true) {
            if(sum1 == sum2) break;
            if(queue1_cnt > max_count && queue2_cnt > max_count) return -1;
            if(sum1 > sum2) {
                int x = queueOne.poll();
                sum1 -= x;
                sum2 += x;
                queueTwo.offer(x);
                answer++;
                queue1_cnt++;
            }
            
            if(sum2 > sum1) {
                int x = queueTwo.poll();
                sum1 += x;
                sum2 -= x;
                queueOne.offer(x);
                answer++;
                queue2_cnt++;
            }
            
            
        }
        return answer;
    }
}