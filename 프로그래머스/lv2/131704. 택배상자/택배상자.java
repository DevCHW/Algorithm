import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        //컨테이너 벨트
        Queue<Integer> queue = new LinkedList<>();
        
        //보조 컨테이너 벨트
        Stack<Integer> stack = new Stack<>();
        
        for(int i=1; i<=order.length; i++) {
            queue.offer(i);
        }
        
        for(int x : order) {
            int order_box = x; //실어야 하는 박스
            
            while(true) {
                if(!queue.isEmpty()) { //컨테이너가 비어있지 않다면
                    int cur_box = queue.peek();
                    if(order_box == cur_box) { //먼저, queue에서 꺼낸 값과 비교
                        queue.poll();
                        answer++;
                        break;
                    } else { //다르다면 보조컨테이너에서 비교
                        if(!stack.isEmpty() && stack.peek() == order_box) {
                            stack.pop();
                            answer++;
                            break;
                        } else {
                            stack.push(cur_box);
                            queue.poll();
                        }
                    }
                } else { //컨테이너가 비었다면
                    if(!stack.isEmpty() && stack.peek() == order_box) {
                        stack.pop();
                        answer++;
                        break;
                    } else {
                        return answer;
                    }
                }
            }// end of while--
        }
        
        return answer;
    }
}