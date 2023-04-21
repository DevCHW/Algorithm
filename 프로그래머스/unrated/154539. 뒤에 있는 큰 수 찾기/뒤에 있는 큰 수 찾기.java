import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        // 접근 : O(n^2) 으로 풀면 n의 크기가 1,000,000 이기 때문에 안될 것 같음.
        Stack<Integer> stack = new Stack<>();
        for(int i=numbers.length-1; i>=0; i--) {
            while(!stack.isEmpty()) {
                if (numbers[i] < stack.peek()) {
                    answer[i] = stack.peek();
                    break;
                } else {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) answer[i] = -1;
            stack.push(numbers[i]);
        }
        
        return answer;
    }
}