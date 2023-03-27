import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<progresses.length; i++) {
            int a = progresses[i];
            int b = speeds[i];
            if((100-a)%b == 0) {
                queue.offer((100-a)/b);
            } else {
                queue.offer(((100-a)/b)+1);
            }
        }
        
        int a = queue.poll();
        int count = 1;
        List<Integer> list = new ArrayList<>();
        
        while(!queue.isEmpty()) {
            int b = queue.poll();
            
            if(a >= b) {
                count++;
            } else {
                list.add(count);
                count = 1;
                a = b;
            }
        }
        list.add(count);
        answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}